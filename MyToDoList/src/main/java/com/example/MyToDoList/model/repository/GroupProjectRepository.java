package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.GroupProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupProjectRepository extends JpaRepository<GroupProject, Long> {
}
