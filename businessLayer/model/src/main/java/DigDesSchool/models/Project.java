package DigDesSchool.models;

import DigDesSchool.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Builder
@Data
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectIdSequence")
    private Long id;

    @Column(name = "projectCode", unique = true, nullable = false)
    private Long projectCode; // код проекта (уникальный среди всех проектов)

    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Column(name = "projectStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus; // статус проекта из enum ProjectStatus; меняется последовательно

    @Column(name = "projectDescription")
    private String projectDescription; // поле с описанием проекта

}
