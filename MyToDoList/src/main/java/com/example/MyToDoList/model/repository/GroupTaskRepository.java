package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.GroupTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupTaskRepository extends JpaRepository<GroupTask, Long> {
}
