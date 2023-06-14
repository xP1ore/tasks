package dto.project.input;

import enums.ProjectStatus;

public class CreateProjectDto {
    public String projectName;
    public String projectDescription;
    public final ProjectStatus projectStatus = ProjectStatus.DRAFT;
}
