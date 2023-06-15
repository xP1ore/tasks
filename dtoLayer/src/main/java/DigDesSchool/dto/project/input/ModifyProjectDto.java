package DigDesSchool.dto.project.input;

import DigDesSchool.enums.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Данные для изменения записи проекта")
public class ModifyProjectDto {

    @Schema(description = "Уникальный код проекта")
    private Long projectCode;

    @Schema(description = "Название проекта")
    private String projectName;

    @Schema(description = "Описание проекта")
    private String projectDescription;

    @Schema(description = "Статус проекта")
    private ProjectStatus projectStatus;

}
