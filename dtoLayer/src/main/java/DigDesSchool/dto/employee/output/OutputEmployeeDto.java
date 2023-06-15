package DigDesSchool.dto.employee.output;

import DigDesSchool.enums.EmployeeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Данные для отображения результата операций для сотрудника")
public class OutputEmployeeDto {

    @Schema(description = "Имя сотрудника")
    private String firstName;

    @Schema(description = "Фамилия сотрудника")
    private String lastName;

    @Schema(description = "Адрес электронной почты сотрудника")
    private String emailAddress;

    @Schema(description = "Статус сотрудника")
    private EmployeeStatus employeeStatus;
}
