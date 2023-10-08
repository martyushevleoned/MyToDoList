package com.example.MyToDoList.service;


import com.example.MyToDoList.model.dto.ProjectDto;
import com.example.MyToDoList.model.dto.TaskDto;
import com.example.MyToDoList.model.dto.UserDto;
import com.example.MyToDoList.model.entity.Project;
import com.example.MyToDoList.model.entity.Task;
import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.model.repository.ProjectRepository;
import com.example.MyToDoList.model.repository.TaskRepository;
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

    @Autowired
    private TaskRepository taskRepository;

    public UserDto getUserDto(User user) {

        User userDb = userRepository.findByUsername(user.getUsername());

        List<ProjectDto> projects = new ArrayList<>();
        userDb.getProjects().forEach(p -> {

            List<TaskDto> tasks = new ArrayList<>();
            p.getTasks().forEach(t -> {

                tasks.add(new TaskDto(t.getId(), t.getTitle(), t.getText()));
            });

            projects.add(new ProjectDto(p.getId(), p.getName(), tasks));
        });

        return new UserDto(userDb.getId(), userDb.getUsername(), projects);
    }

    public void addProject(User user, String projectName) {

        User userDb = userRepository.findByUsername(user.getUsername());
        Project project = new Project(projectName, userDb);
        projectRepository.save(project);
    }

    public void addTask(Long projectId, String title, String text){

        Project projectDb = projectRepository.getReferenceById(projectId);
        Task task = new Task(title, text, projectDb);
        taskRepository.save(task);
    }
}
