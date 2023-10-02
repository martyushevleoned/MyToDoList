package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.Entity.Project;
import com.example.MyToDoList.model.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/projects")
    public String projects(Model model) {

        Iterable<Project> projects = projectRepository.findAll();

        String some = "some text";

        model.addAttribute("projects", projects);
        model.addAttribute("some", some);

        return "projects";
    }

    @PostMapping("/projects/add")
    public String addProject(@RequestParam String userId, @RequestParam String name, Model model) {
        projectRepository.save(new Project(Long.parseLong(userId), name));

        Iterable<Project> projects = projectRepository.findAll();
        String some = "some text";
        model.addAttribute("projects", projects);
        model.addAttribute("some", some);

        return "projects";
    }

}
