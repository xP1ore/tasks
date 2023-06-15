package DigDesSchool.mapping.impl;

import DigDesSchool.dto.project.input.CreateProjectDto;
import DigDesSchool.dto.project.input.ModifyProjectDto;
import DigDesSchool.dto.project.output.OutputProjectDto;
import DigDesSchool.mapping.EntityMapper;
import DigDesSchool.models.Project;

import java.lang.reflect.Field;

public class ProjectMapper implements EntityMapper<Project, CreateProjectDto, OutputProjectDto, ModifyProjectDto> {

    @Override
    public Project mapToEntity(CreateProjectDto newProject) {
        return Project.builder()
                .projectName(newProject.getProjectName())
                .projectCode(newProject.getProjectCode())
                .projectStatus(newProject.getProjectStatus())
                .projectDescription(newProject.getProjectDescription())
                .build();
    }

    @Override
    public OutputProjectDto mapToOutput(Project project) {
        return OutputProjectDto.builder()
                .projectName(project.getProjectName())
                .projectStatus(project.getProjectStatus())
                .projectCode(project.getProjectCode())
                .projectDescription(project.getProjectDescription())
                .build();
    }

    @Override
    public Project mapModifyEntityDto(ModifyProjectDto projectToModify) {
        return Project.builder()
                .projectName(projectToModify.getProjectName())
                .projectStatus(projectToModify.getProjectStatus())
                .projectCode(projectToModify.getProjectCode())
                .projectDescription(projectToModify.getProjectDescription())
                .build();
    }

    @Override
    public Project updateNonNullFields(Project source, Project target) throws IllegalAccessException {
        Class<?> projectClass = source.getClass();
        Field[] fields = projectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null) {
                field.set(target, value);
            }
        }
        return target;
    }


}
