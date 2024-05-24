package com.example.backendtest.dto;

import lombok.Data;

@Data
public class TasksDto {
    private Integer id;
    private String title;
    private String assignees;
    private String status;
}
