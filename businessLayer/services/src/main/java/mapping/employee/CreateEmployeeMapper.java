package mapping.employee;

import dto.employee.input.CreateEmployeeDto;
import dto.employee.output.CreatedEmployeeDto;
import enums.EmployeeStatus;
import mapping.Mapper;
import models.Employee;

import java.util.Objects;

public class CreateEmployeeMapper implements Mapper<Employee, CreateEmployeeDto, CreatedEmployeeDto> {
    @Override
    public Employee mapToEntity(CreateEmployeeDto newEmployee) {
        return Employee.builder()
                .firstName(newEmployee.firstName)
                .lastName(newEmployee.lastName)
                .emailAddress(newEmployee.emailAddress)
                .build();
    }

    @Override
    public CreatedEmployeeDto mapToOutput(Employee employee) {
        return CreatedEmployeeDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .emailAddress(employee.getEmailAddress())
                .employeeStatus(employee.getStatus())
                .build();
    }
}
