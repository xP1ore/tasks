package controllers;

import dto.employee.input.CreateEmployeeDto;
import dto.employee.input.DeleteEmployeeDto;
import dto.employee.output.CreatedEmployeeDto;
import lombok.AllArgsConstructor;
import services.EmployeeService;

import java.io.IOException;
import java.sql.SQLException;

@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    public void createNewEmployee(CreateEmployeeDto newEmployee) throws IOException, SQLException {
        CreatedEmployeeDto createdEmployee = employeeService.createNewEmployee(newEmployee);

    }

    public void deleteEmployee(DeleteEmployeeDto employeeToDelete) {

    }

}
