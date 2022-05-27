package company.hsenid.employeewebapplication.services;

import company.hsenid.employeewebapplication.models.Project;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ProjectService {
        Set<Project> getProjects();
}
