package company.hsenid.employeewebapplication.repositories;

import company.hsenid.employeewebapplication.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByFirstname(String Name);
}
