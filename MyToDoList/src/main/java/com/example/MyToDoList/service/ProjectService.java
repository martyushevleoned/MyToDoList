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
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    public UserDto getUserDto(User user) {

        Optional<User> userDb = userRepository.findById(user.getId());

        if (userDb.isEmpty())
            throw new RuntimeException("user with id " + user.getId() + " doesn't exist");

        List<ProjectDto> projects = new ArrayList<>();
        userDb.get().getProjects().forEach(p -> {

            List<TaskDto> tasks = new ArrayList<>();
            p.getTasks().forEach(t -> {

                tasks.add(new TaskDto(t.getId(), t.getTitle(), t.getText()));
            });

            projects.add(new ProjectDto(p.getId(), p.getName(), tasks));
        });

        return new UserDto(userDb.get().getId(), userDb.get().getUsername(), projects);
    }

    public void addProject(User user, String projectName) {

        User userDb = getUserDb(user.getId());
        Project project = new Project(projectName, userDb);
        projectRepository.save(project);
    }

    public void addTask(User user, Long projectId, String title, String text) {

        User userDb = getUserDb(user.getId());
        Project projectDb = getProjectDb(projectId);
        usersEquals(userDb, projectDb.getUser());
        Task task = new Task(title, text, projectDb);
        taskRepository.save(task);
    }

    public void deleteProject(User user, Long projectId) {

        User userDb = getUserDb(user.getId());
        Project projectDb = getProjectDb(projectId);
        usersEquals(userDb, projectDb.getUser());
        projectRepository.deleteById(projectId);
    }

    public void deleteTask(User user, Long taskId) {

        User userDb = getUserDb(user.getId());
        Task taskDb = getTaskDb(taskId);
        usersEquals(userDb, taskDb.getProject().getUser());
        taskRepository.deleteById(taskId);
    }

    private User getUserDb(Long userId) {
        Optional<User> userDb = userRepository.findById(userId);

        if (userDb.isEmpty())
            throw new RuntimeException("user with id " + userId + " doesn't exist");

        return userDb.get();
    }

    private Project getProjectDb(Long projectId) {
        Optional<Project> projectDb = projectRepository.findById(projectId);

        if (projectDb.isEmpty())
            throw new RuntimeException("project with id " + projectId + " doesn't exist");

        return projectDb.get();
    }

    private Task getTaskDb(Long taskId) {
        Optional<Task> taskDb = taskRepository.findById(taskId);

        if (taskDb.isEmpty())
            throw new RuntimeException("task with id " + taskId + " doesn't exist");

        return taskDb.get();
    }

    private void usersEquals(User userDb, User userOwner) {
        if (!Objects.equals(userDb.getId(), userOwner.getId()))
            throw new RuntimeException("user with id " + userDb.getId() +
                    " tried to change project of user with id " + userOwner.getId());
    }
}
