package ssi2testbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ssi2testbe.entities.Task;
import ssi2testbe.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Task getTaskById(Integer id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public Page<Task> getTasks(String partOfTaskTitle, String[] sortBy, String[] direction, int pageNo, int pageSize) {
//        Sort.Order sortOrder = null;
        if (sortBy != null && sortBy.length > 0) {
            List<Sort.Order> sortOrderList = new ArrayList<>();
            for (int i = 0; i < sortBy.length; i++) {
                sortOrderList.add(new Sort.Order(Sort.Direction.valueOf(direction[i].toUpperCase()), sortBy[i]));
            }
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrderList));
            return taskRepository.findAllByTitleContains(partOfTaskTitle, pageable);
        } else {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return taskRepository.findAllByTitleContains(partOfTaskTitle, pageable);
        }
    }
}
