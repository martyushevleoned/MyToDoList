package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.dto.ProjectDto;
import com.example.MyToDoList.model.dto.UserDto;
import com.example.MyToDoList.model.entity.User;
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

    @Autowired
    private ProjectService projectService;


    @GetMapping("/list")
    public String projects(@AuthenticationPrincipal User user,
                           Model model) {

        UserDto userDto = projectService.getUserDto(user);
        model.addAttribute("user", userDto);

        return "projects";
    }

    @PostMapping("/add/project")
    public String addProject(@AuthenticationPrincipal User user,
                             @RequestParam String name,
                             Model model) {

        projectService.addProject(user, name);

        UserDto userDto = projectService.getUserDto(user);
        model.addAttribute("user", userDto);

        return "projects";
    }

    @PostMapping("/add/task")
    public String addTask(@AuthenticationPrincipal User user,
                          @RequestParam Long id,
                          @RequestParam String title,
                          @RequestParam String text,
                          Model model) {

        projectService.addTask(id, title, text);

        UserDto userDto = projectService.getUserDto(user);
        model.addAttribute("user", userDto);

        return "projects";
    }

}
