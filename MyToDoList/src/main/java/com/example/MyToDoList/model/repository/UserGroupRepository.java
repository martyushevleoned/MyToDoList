package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
