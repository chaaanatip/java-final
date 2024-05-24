package ssi2testbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ssi2testbe.entities.TaskStatus;

import java.util.Date;

@Data
public class TaskListDto {
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private String title;
    private TaskStatus status;
    private Date createdOn;
    private Date updatedOn;

    public String getTitleId(){
        return title + " " + id;
    }

}
