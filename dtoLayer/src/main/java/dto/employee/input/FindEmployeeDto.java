package dto.employee.input;


import enums.EmployeeStatus;

// dto для поиска сотрудников
public class FindEmployeeDto {
    public Long id;
    public String firstName;
    public String lastName;
    public EmployeeStatus employeeStatus;
}
