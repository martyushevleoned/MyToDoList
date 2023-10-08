package com.example.MyToDoList.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    Long id;
    String username;
    Iterable<ProjectDto> projects;
}
