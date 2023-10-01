package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.Entity.Project;
import com.example.MyToDoList.model.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/projects")
    public String projects(Model model) {

//        Iterable<Project> projects = projectRepository.findAll();

        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L,"project1"));
        projects.add(new Project(1L,"project2"));


        String some = "some text";

        model.addAttribute("projects", projects);
        model.addAttribute("some", some);

        return "projects";
    }

}
