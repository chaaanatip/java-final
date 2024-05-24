package com.example.backend2.controllers;

import com.example.backend2.dtos.TaskDto;
import com.example.backend2.dtos.TasksDto;
import com.example.backend2.entities.Task;
import com.example.backend2.services.TaskService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<TasksDto>> getAllTasks() {
        List<Task> results = taskService.getAllTasks();
        List<TasksDto> tasks = results.stream().map(e -> modelMapper.map(e, TasksDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task id %d does not exist.", taskId));
        TaskDto taskDto = modelMapper.map(task, TaskDto.class);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }
    }
