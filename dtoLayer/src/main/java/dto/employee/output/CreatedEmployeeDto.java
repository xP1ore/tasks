package dto.employee.output;

import enums.EmployeeStatus;
import lombok.Builder;

@Builder
public class CreatedEmployeeDto {
    public String firstName;
    public String lastName;
    public String emailAddress;
    public EmployeeStatus employeeStatus;
}
