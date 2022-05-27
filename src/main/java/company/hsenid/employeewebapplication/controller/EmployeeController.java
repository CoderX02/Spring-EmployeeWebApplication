package company.hsenid.employeewebapplication.controller;

import company.hsenid.employeewebapplication.mapper.EmployeeMapper;
import company.hsenid.employeewebapplication.models.Employee;
import company.hsenid.employeewebapplication.models.Project;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import company.hsenid.employeewebapplication.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(description = "This is my Employee Controller")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "This will create an Employee", notes = " You only need to give first and lastname ")
    @PostMapping("/create")
    public void CreateEmployee(@RequestBody Employee employees){
        employeeService.insertEmployee(employees);
    }

    @ApiOperation(value="This will delete an employee", notes = "you only need to pass the id")
    @PostMapping ("/delete-employee/{id}")
    public void DeleteEmployee(@PathVariable String id){
        employeeService.deleteUser(id);
    }

    @ApiOperation(value = "Lists all the employees present")
    @GetMapping(" ")
    public List<Employee> ListEmployees(){
        return employeeService.fetchAllEmployee();
    }

    @ApiOperation(value = "This will find the details of specific employees by their id")
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/user/{id}"
    )
    public ResponseEntity<?> findEmployee(@PathVariable String id ) {
        return employeeService.fetchEmployee(id);
    }

    @ApiOperation(value = "This will update the existing employees details")
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<?> UpdateEmployee(@PathVariable String id, @RequestBody Employee employees) {
        return employeeService.UpdateEmployee(id,employees);
    }

}
