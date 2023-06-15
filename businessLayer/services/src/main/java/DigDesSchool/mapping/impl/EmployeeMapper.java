package DigDesSchool.mapping.impl;

import DigDesSchool.dto.employee.input.CreateEmployeeDto;
import DigDesSchool.dto.employee.input.ModifyEmployeeDto;
import DigDesSchool.dto.employee.output.OutputEmployeeDto;
import DigDesSchool.mapping.EntityMapper;
import DigDesSchool.models.Employee;

import java.lang.reflect.Field;

public class EmployeeMapper implements EntityMapper<Employee, CreateEmployeeDto,
        OutputEmployeeDto, ModifyEmployeeDto> {

    @Override
    public Employee mapToEntity(CreateEmployeeDto newEmployee) {
        return Employee.builder()
                .firstName(newEmployee.getFirstName())
                .lastName(newEmployee.getLastName())
                .emailAddress(newEmployee.getEmailAddress())
                .build();
    }

    @Override
    public OutputEmployeeDto mapToOutput(Employee employee) {
        return OutputEmployeeDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeStatus(employee.getStatus())
                .emailAddress(employee.getEmailAddress())
                .build();
    }

    @Override
    public Employee mapModifyEntityDto(ModifyEmployeeDto employeeToModify) {
        return Employee.builder()
                .firstName(employeeToModify.firstName)
                .lastName(employeeToModify.lastName)
                .emailAddress(employeeToModify.emailAddress)
                .build();
    }


    @Override
    public Employee updateNonNullFields(Employee source, Employee target) throws IllegalAccessException{
        Class<?> employeeClass = source.getClass();
        Field[] fields = employeeClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null) {
                field.set(target, value);
            }
        }
        return target;
    }
}
