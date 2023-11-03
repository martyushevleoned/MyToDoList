package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
