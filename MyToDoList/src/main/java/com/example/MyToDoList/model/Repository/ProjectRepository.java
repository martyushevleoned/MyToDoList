package com.example.MyToDoList.model.Repository;

import com.example.MyToDoList.model.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
