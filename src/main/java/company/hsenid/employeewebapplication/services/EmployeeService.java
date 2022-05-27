package company.hsenid.employeewebapplication.services;

import company.hsenid.employeewebapplication.mapper.EmployeeMapper;
import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee insertEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> fetchAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void deleteUser(String id){
        employeeRepository.deleteById(id);
    }

    public ResponseEntity<?> fetchEmployee(String id){
        Optional<Employee> employeesOptional = employeeRepository.findById(id);
        if(employeesOptional.isPresent()) {
            return ResponseEntity.ok(employeesOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee" + id + " was not found");
    }

    public ResponseEntity<?> UpdateEmployee(String id,Employee employee){
        Optional<Employee> employeesOptional = employeeRepository.findById(id);
        if(employeesOptional.isPresent()) {
            employeeRepository.save(EmployeeMapper.employeeMapper(employeesOptional.get(),employee));
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee" + id + " was not found");
        }
    }

    public List<Employee> FindByName(String name){
        return employeeRepository.findEmployeeByFirstname(name);
    }

}
