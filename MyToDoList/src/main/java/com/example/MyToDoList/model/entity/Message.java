package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatId", foreignKey = @ForeignKey(name = "CHT_FK"))
    private GroupProject groupProject;

    @ManyToOne
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "USR_CHT_FK"))
    private User user;

    private String text;
}
