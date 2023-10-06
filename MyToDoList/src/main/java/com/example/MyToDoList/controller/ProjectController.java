package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.dto.ProjectDto;
import com.example.MyToDoList.model.entity.Project;
import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.model.repository.ProjectRepository;
import com.example.MyToDoList.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/projects")
public class ProjectController {

//    @Autowired
//    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;


    @GetMapping("/list")
    public String projects(@AuthenticationPrincipal User user,
                           Model model) {

        Iterable<ProjectDto> projects = projectService.getProjectList(user);
        model.addAttribute("projects", projects);

        return "projects";
    }

    @PostMapping("/add")
    public String addProject(@AuthenticationPrincipal User user,
                             @RequestParam String name,
                             Model model) {

        projectService.addProject(user, name);

        Iterable<ProjectDto> projects = projectService.getProjectList(user);
        model.addAttribute("projects", projects);

        return "projects";
    }

}
