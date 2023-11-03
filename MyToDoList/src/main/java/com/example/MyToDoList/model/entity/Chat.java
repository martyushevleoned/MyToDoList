package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats")
@Data
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ownerId", foreignKey = @ForeignKey(name = "USR_CHT_FK"))
    private User user;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "chat")
    private List<UserChat> userChats = new ArrayList<>();
}
