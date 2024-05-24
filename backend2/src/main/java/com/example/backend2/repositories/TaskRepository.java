package com.example.backend2.repositories;
import com.example.backend2.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer>{
    List<Task> findAllByOrderByCreatedOnAsc();
}
