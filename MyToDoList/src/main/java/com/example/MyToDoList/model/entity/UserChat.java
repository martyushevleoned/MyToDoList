package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_chats")
public class UserChat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "USRCHT_USR_FK"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatId", foreignKey = @ForeignKey(name = "USRCHT_CHT_FK"))
    private Chat chat;
}
