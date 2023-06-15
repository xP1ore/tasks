package DigDesSchool.dto.employee.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

@Schema(description = "Данные для создания записи сотрудника")
public class CreateEmployeeDto {

    @Schema(description = "Имя сотрудника")
    private String firstName;

    @Schema(description = "Фамилия сотрудника")
    private String lastName;

    @Schema(description = "Адрес электронной почты сотрудника")
    private String emailAddress;
}
