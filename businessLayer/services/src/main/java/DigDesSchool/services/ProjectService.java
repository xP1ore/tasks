package DigDesSchool.services;

import DigDesSchool.dto.project.input.CreateProjectDto;
import DigDesSchool.dto.project.output.OutputProjectDto;
import DigDesSchool.mapping.impl.ProjectMapper;
import DigDesSchool.models.Project;
import DigDesSchool.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    ProjectRepository projectRepository;
    ProjectMapper projectMapper;

    public OutputProjectDto createNewProject(CreateProjectDto newProject) {
        final Project project = projectMapper.mapToEntity(newProject);
        projectRepository.save(project);
        return projectMapper.mapToOutput(project);
    }

}
