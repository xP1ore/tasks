package DigDesSchool.dto.employee.input;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные для изменения учетной записи сотрудника")
public class ModifyEmployeeDto {

    @Schema(description = "Id сотрудника")
    public Long employeeId;

    @Schema(description = "Имя сотрудника")
    public String firstName;

    @Schema(description = "Фамилия сотрудника")
    public String lastName;

    @Schema(description = "Электронная почта сотрудника")
    public String emailAddress;
}
