package com.example.MyToDoList.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDto {

    Long id;
    String title;
    String text;
}
