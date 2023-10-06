package com.example.MyToDoList.service;


import com.example.MyToDoList.model.dto.ProjectDto;
import com.example.MyToDoList.model.entity.Project;
import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.model.repository.ProjectRepository;
import com.example.MyToDoList.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Iterable<ProjectDto> getProjectList(User user) {

        List<ProjectDto> projects = new ArrayList<>();
        userRepository.findByUsername(user.getUsername()).getProjects().forEach(p -> projects.add(new ProjectDto(p.getName())));
        return projects;
    }

    public void addProject(User user, String projectName){

        projectRepository.save(new Project(projectName, userRepository.findByUsername(user.getUsername())));
    }
}
