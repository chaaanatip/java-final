package ssi2testbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ssi2testbe.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByOrderByCreatedOnAsc();
    Page<Task> findAllByTitleContains(String partOfTaskTitle, Pageable pageable);
}
