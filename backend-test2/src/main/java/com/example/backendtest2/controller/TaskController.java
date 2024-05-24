package com.example.backendtest2.controller;

import com.example.backendtest2.dto.TaskListDto;
import com.example.backendtest2.entities.Task;
import com.example.backendtest2.service.TaskService;
import com.example.backendtest2.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public TaskController(TaskService service, ModelMapper modelMapper, ListMapper listMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTasks() {
        List<Task> tasks = service.getAllTasks();
        List<TaskListDto> taskListDtos = listMapper.mapList(tasks, TaskListDto.class, modelMapper);
        return ResponseEntity.ok(taskListDtos);
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Integer taskId) {
        return service.getTaskById(taskId);
    }

}
