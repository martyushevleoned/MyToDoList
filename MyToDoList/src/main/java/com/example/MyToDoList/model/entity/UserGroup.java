package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_groups")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "USR_USR_FK"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatId", foreignKey = @ForeignKey(name = "GRP_GRP_FK"))
    private GroupProject groupProject;
}
