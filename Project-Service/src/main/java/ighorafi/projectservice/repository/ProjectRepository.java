package ighorafi.projectservice.repository;

import ighorafi.projectservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {
}
