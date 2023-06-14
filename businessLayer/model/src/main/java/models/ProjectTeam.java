package models;

import enums.ProjectMemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
// команда проекта (список связей проект - сотрудник - роль сотрудника в проекте)
public class ProjectTeam {
    private Long id;
    private Project project;
    private Employee employee;
    private ProjectMemberRole role;
}
