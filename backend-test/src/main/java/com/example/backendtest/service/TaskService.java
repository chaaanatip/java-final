package com.example.backendtest.service;

import com.example.backendtest.entities.Task;
import com.example.backendtest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {

        return taskRepository.findAllByOrderByCreatedOnAsc();
    }
}
