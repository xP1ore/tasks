package dto.employee.input;

import enums.EmployeeStatus;

// dto для изменения записи сотрудника
public class ModifyEmployeeDto {
    public Long employeeId;
    public EmployeeStatus employeeStatus;
}
