package com.example.backend2.dtos;

import com.example.backend2.entities.TaskStatus;
import lombok.Data;

import java.util.Date;
@Data
public class TaskDto {
    private Integer id;
    private String title;
    private String description;
    private String assignees;
    private TaskStatus status;
    private Date createdOn;
    private Date updatedOn;

    public String getCreatedOn() {
        return createdOn.toString();
    }

    public String getUpdatedOn() {
        return updatedOn.toString();
    }
}
