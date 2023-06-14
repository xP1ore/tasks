package services;

import dao.EmployeeDao;
import dto.employee.input.CreateEmployeeDto;
import dto.employee.input.DeleteEmployeeDto;
import dto.employee.output.CreatedEmployeeDto;
import enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import mapping.employee.CreateEmployeeMapper;
import models.Employee;
import repositories.fileRepositories.impl.EmployeeFileRepository;

import java.io.IOException;
import java.sql.SQLException;

@AllArgsConstructor
public class EmployeeService {

    CreateEmployeeMapper createEmployeeMapper;
    ModifyEmployeeMapper modifyEmployeeMapper;
    FindEmployeeMapper findEmployeeMapper;
    EmployeeDao employeeDao;
    EmployeeFileRepository employeeRepository;

    public CreatedEmployeeDto createNewEmployee(CreateEmployeeDto data) throws IOException, SQLException {
        final Employee employee = createEmployeeMapper.mapToEntity(data);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.create(employee);
        employeeDao.create(employee);
        return createEmployeeMapper.mapToOutput(employee);
    }

    public void deleteEmployee(DeleteEmployeeDto employeeToDelete) throws SQLException{
        employeeDao.delete(employeeToDelete.id);
    }


}
