package company.hsenid.employeewebapplication.controller;

import company.hsenid.employeewebapplication.mapper.EmployeeMapper;
import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.models.Project;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/create")
    public void CreateEmployee(@RequestBody Employee employees){
        employeeRepository.insert(employees);
    }

    @PostMapping ("/delete/{id}")
    public void DeleteEmployee(@PathVariable String id){
        employeeRepository.deleteById(id);
    }

    @GetMapping("/")
    public List<Employee> ListEmployees(){
        return employeeRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/user/{id}"
    )
    public ResponseEntity<?> fetchEmployee(@PathVariable String id ) {
        Optional<Employee> employeesOptional = employeeRepository.findById(id);
        if(employeesOptional.isPresent()) {
            return ResponseEntity.ok(employeesOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee" + id + " was not found");
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<?> UpdateEmployee(@PathVariable String id, @RequestBody Employee employees) {
        Optional<Employee> employeesOptional = employeeRepository.findById(id);
        if(employeesOptional.isPresent()) {
            employeeRepository.save(EmployeeMapper.employeeMapper(employeesOptional.get(),employees));
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee" + id + " was not found");
        }
    }

}
