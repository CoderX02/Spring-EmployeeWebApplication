package company.hsenid.employeewebapplication.controller;

import company.hsenid.employeewebapplication.mapper.EmployeeMapper;
import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.models.Project;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import company.hsenid.employeewebapplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public void CreateEmployee(@RequestBody Employee employees){
        employeeService.insertEmployee(employees);
    }

    @PostMapping ("/delete-employee/{id}")
    public void DeleteEmployee(@PathVariable String id){
        employeeService.deleteUser(id);
    }

    @GetMapping("/employee/list")
    public List<Employee> ListEmployees(){
        return employeeService.fetchAllEmployee();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/user/{id}"
    )
    public ResponseEntity<?> findEmployee(@PathVariable String id ) {
        return employeeService.fetchEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<?> UpdateEmployee(@PathVariable String id, @RequestBody Employee employees) {
        return employeeService.UpdateEmployee(id,employees);
    }

}
