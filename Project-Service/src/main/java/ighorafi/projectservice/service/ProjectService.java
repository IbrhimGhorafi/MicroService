package ighorafi.projectservice.service;

import ighorafi.projectservice.entity.Project;
import ighorafi.projectservice.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;
    public Project addNewProject(Project project){
        projectRepository.save(project);
        return project;
    }
    public List<Project> getAllProjects(){
        List<Project> all = projectRepository.findAll();
        return all;
    }
    public Project getProjectById(String id){
        return projectRepository.findById(id).orElse(null);
    }
}
