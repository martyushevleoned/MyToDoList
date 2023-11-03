package com.example.MyToDoList.model.repository;


import com.example.MyToDoList.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
