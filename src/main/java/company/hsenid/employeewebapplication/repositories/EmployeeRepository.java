package company.hsenid.employeewebapplication.repositories;

import company.hsenid.employeewebapplication.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
