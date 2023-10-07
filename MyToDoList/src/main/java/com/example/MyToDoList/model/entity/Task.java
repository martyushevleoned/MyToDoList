package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn(name = "projectId", foreignKey = @ForeignKey(name = "PRJ_TSK_FK"))
    private Project project;

    public Task(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
