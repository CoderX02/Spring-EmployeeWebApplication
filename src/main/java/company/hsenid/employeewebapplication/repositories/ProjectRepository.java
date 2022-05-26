package company.hsenid.employeewebapplication.repositories;

import company.hsenid.employeewebapplication.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
