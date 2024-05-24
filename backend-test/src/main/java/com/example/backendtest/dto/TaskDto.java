package com.example.backendtest.dto;

import lombok.Data;

@Data
public class TaskDto {
private String title;
private String description;
private String assignees;
private String status;
private String createdOn;
private String updatedOn;

}
