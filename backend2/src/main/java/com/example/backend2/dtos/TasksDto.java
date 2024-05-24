package com.example.backend2.dtos;

import com.example.backend2.entities.TaskStatus;
import lombok.Data;

@Data
public class TasksDto {
    private Integer id;
    private String title;
    private String assignees;
    private TaskStatus status;
}
