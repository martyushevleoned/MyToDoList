package com.example.MyToDoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {

    Long id;
    String name;
    Iterable<TaskDto> tasks;
}
