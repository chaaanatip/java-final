package com.example.backendtest2.service;

import com.example.backendtest2.entities.Task;
import com.example.backendtest2.repository.TaskRepository;
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
    public Task getTaskById(Integer taskId){
        return taskRepository.findById(taskId).orElseThrow( () -> new RuntimeException("Task not found"));
    }
}
