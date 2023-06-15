package DigDesSchool.repositories;

import DigDesSchool.models.ProjectTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, Long> {

}
