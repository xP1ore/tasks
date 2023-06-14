package models;

import enums.ProjectStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class Project implements Serializable {
    private Long id;
    private String projectCode; // код проекта (уникальный среди всех проектов)
    private String projectName;
    private String projectDescription; // поле с описанием проекта
    private ProjectStatus projectStatus; // статус проекта из enum ProjectStatus; меняется последовательно
}
