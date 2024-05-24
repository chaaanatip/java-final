package com.example.backendtest.controller;

import com.example.backendtest.dto.TasksDto;
import com.example.backendtest.entities.Task;

import com.example.backendtest.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController     {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TasksDto>> getAllTasks() {
        List<TasksDto> tasks = results.stream().map(e -> modelMapper.map(e, TasksDto.class)).collect(Collectors.toList());
    }

}
