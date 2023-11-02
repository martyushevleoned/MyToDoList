package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "USR_PRJ_FK"))
    private User user;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Project(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
