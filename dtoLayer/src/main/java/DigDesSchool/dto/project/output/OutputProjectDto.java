package DigDesSchool.dto.project.output;

import DigDesSchool.enums.ProjectStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputProjectDto {
    private Long projectCode;
    private String projectName;
    private String projectDescription;
    private ProjectStatus projectStatus;
}
