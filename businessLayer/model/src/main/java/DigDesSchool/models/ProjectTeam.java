package DigDesSchool.models;

import DigDesSchool.enums.ProjectMemberRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Builder
@Table(name = "projectTeam")
// команда проекта (список связей проект - сотрудник - роль сотрудника в проекте)
public class ProjectTeam {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectTeamIdSequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkProjectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fkEmployeeId", nullable = false)
    private Employee employee;

    @Column(name = "projectMemberRole", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectMemberRole role;
}
