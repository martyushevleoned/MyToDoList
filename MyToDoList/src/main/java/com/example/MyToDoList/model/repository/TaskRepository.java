package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
