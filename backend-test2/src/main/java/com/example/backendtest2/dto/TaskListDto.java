package com.example.backendtest2.dto;

import com.example.backendtest2.entities.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class TaskListDto {


    private Integer id;

    private String title;
    private TaskStatus status;
    private Date createdOn;
    private Date updatedOn;

    public String getTitleId(){
        return title + " " + id;
    }

}
