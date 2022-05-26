package company.hsenid.employeewebapplication.controller;

import company.hsenid.employeewebapplication.repositories.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {


    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping("/projects")
    public String getProjects(Model model){
//        model.addAttribute("Projects", projectRepository.findAll());
        return "Projects";
    }
}
