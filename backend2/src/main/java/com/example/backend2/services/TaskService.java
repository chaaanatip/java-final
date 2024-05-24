 package com.example.backend2.services;

import com.example.backend2.entities.Task;
import com.example.backend2.repositories.TaskRepository;
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

    public Task getTaskById(Integer taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
}
