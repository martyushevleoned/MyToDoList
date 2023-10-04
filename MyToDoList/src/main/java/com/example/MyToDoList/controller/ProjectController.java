package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.entity.Project;
import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.model.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping("/projects")
    public String projects(@AuthenticationPrincipal User user,
                           Model model) {

        Iterable<Project> projects = projectRepository.findByUserId(user.getId());
        String some = "some text";
        model.addAttribute("projects", projects);
        model.addAttribute("some", some);

        return "projects";
    }

    @PostMapping("/projects/add")
    public String addProject(@AuthenticationPrincipal User user,
                             @RequestParam String name,
                             Model model) {

        projectRepository.save(new Project(user.getId(), name));


        Iterable<Project> projects = projectRepository.findByUserId(user.getId());
        String some = "some text";
        model.addAttribute("projects", projects);
        model.addAttribute("some", some);

        return "projects";
    }

}
