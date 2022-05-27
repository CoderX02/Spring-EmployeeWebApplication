package company.hsenid.employeewebapplication.services;

import company.hsenid.employeewebapplication.models.Project;
import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class ProjectServicesImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServicesImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Set<Project> getProjects() {
        log.debug("In the Project services");

        Set<Project> projectSet = new HashSet<>();
        projectRepository.findAll().iterator().forEachRemaining(projectSet :: add);
        return projectSet;
    }
}
 