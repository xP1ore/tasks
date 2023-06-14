package dto.project.input;

import enums.ProjectStatus;

public class UpdateProjectStatusDto {
    public Long id;
    public String projectName;
    public ProjectStatus newProjectStatus;
}
