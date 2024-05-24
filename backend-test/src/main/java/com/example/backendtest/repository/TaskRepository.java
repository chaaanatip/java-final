package com.example.backendtest.repository;

import com.example.backendtest.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByOrderByCreatedOnAsc();
}
