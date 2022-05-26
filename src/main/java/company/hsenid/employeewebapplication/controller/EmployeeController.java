package company.hsenid.employeewebapplication.controller;

import company.hsenid.employeewebapplication.models.Project;
import company.hsenid.employeewebapplication.repositories.EmployeeRepository;
import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/employees")
    public String getEmployees(Model model){
//        model.addAttribute("Employees", employeeRepository.findAll());
        return "Employees";
    }

}
