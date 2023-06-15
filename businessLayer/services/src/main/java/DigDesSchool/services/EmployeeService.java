package DigDesSchool.services;

import DigDesSchool.dto.employee.input.CreateEmployeeDto;
import DigDesSchool.dto.employee.input.ModifyEmployeeDto;
import DigDesSchool.dto.employee.output.OutputEmployeeDto;
import DigDesSchool.enums.EmployeeStatus;
import DigDesSchool.exceptions.EmployeeDoesNotExistsException;
import DigDesSchool.exceptions.TryToModifyDeletedEmployeeException;
import DigDesSchool.mapping.impl.EmployeeMapper;
import DigDesSchool.repositories.EmployeeRepository;
import DigDesSchool.models.Employee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    EmployeeMapper employeeMapper;
    EmployeeRepository employeeRepository;


    public OutputEmployeeDto createNewEmployee(@NonNull CreateEmployeeDto data) {
        final Employee employee = employeeMapper.mapToEntity(data);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.save(employee);
        return employeeMapper.mapToOutput(employee);
    }

    public OutputEmployeeDto deleteEmployee(@NonNull Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        employee.setStatus(EmployeeStatus.REMOVED);
        employeeRepository.save(employee);
        return employeeMapper.mapToOutput(employee);
    }

    public OutputEmployeeDto modifyEmployee(@NonNull ModifyEmployeeDto employeeToModify) throws IllegalAccessException{
        Optional<Employee> employee = employeeRepository.findById(employeeToModify.employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeDoesNotExistsException(
                    "Employee with id %d does not exist".formatted(employeeToModify.employeeId)
            );
        } else {
            if (employee.get().getStatus().equals(EmployeeStatus.REMOVED)) {
                throw new TryToModifyDeletedEmployeeException("Employee has been deleted");
            }
            else {
                Employee modifiedEmployee = employeeMapper.updateNonNullFields(employeeMapper.mapModifyEntityDto(
                        employeeToModify), employee.get());
                return employeeMapper.mapToOutput(modifiedEmployee);
            }
        }
    }

    public List<OutputEmployeeDto> findEmployees(@NonNull String input) {
        List<Employee> employees = employeeRepository.findByEmployeeStatusAndFirstNameContainingOrLastNameContainingOrEmailAddressContaining(
                EmployeeStatus.ACTIVE,
                input,
                input,
                input
        );
        List<OutputEmployeeDto> output = new ArrayList<>();
        for (Employee e : employees) {
            output.add(employeeMapper.mapToOutput(e));
        }
        return output;
    }

    public OutputEmployeeDto getEmployeeById(@NonNull Long id) {
        return employeeMapper.mapToOutput(employeeRepository.getReferenceById(id));
    }


}
