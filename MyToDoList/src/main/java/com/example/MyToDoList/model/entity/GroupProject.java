package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_projects")
@Data
@NoArgsConstructor
public class GroupProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ownerId", foreignKey = @ForeignKey(name = "USR_CHT_FK"))
    private User user;

    @OneToMany(mappedBy = "groupProject")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "groupProject")
    private List<UserGroup> userGroups = new ArrayList<>();

    @OneToMany(mappedBy = "groupProject", orphanRemoval = true)
    private List<GroupTask> groupTasks = new ArrayList<>();
}
