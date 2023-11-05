package com.example.MyToDoList.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group_tasks")
@Data
@NoArgsConstructor
public class GroupTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn(name = "groupProjectId", foreignKey = @ForeignKey(name = "GRP_PRJ_TSK_FK"))
    private GroupProject groupProject;

    public GroupTask(String title, String text, GroupProject groupProject) {
        this.title = title;
        this.text = text;
        this.groupProject = groupProject;
    }
}
