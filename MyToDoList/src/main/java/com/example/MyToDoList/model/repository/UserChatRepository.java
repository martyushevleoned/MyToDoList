package com.example.MyToDoList.model.repository;

import com.example.MyToDoList.model.entity.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChatRepository extends JpaRepository<UserChat, Long> {
}
