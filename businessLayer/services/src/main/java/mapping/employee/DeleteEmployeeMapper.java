package mapping.employee;

import dto.employee.input.DeleteEmployeeDto;
import mapping.ToEntityMapper;
import models.Employee;

public class DeleteEmployeeMapper implements ToEntityMapper<Employee, DeleteEmployeeDto> {

    @Override
    public Employee mapToEntity(DeleteEmployeeDto deleteEmployeeDto) {
        return Employee.builder()
                .firstName(deleteEmployeeDto.firstName)
                .lastName(deleteEmployeeDto.lastName)
                .id(deleteEmployeeDto.id)
                .build();
    }
}
