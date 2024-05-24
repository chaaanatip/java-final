package ssi2testbe.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssi2testbe.dto.PageDTO;
import ssi2testbe.dto.TaskListDto;
import ssi2testbe.dto.Testdto;
import ssi2testbe.entities.Task;
import ssi2testbe.exceptions.ItemNotFoundException;
import ssi2testbe.services.TaskService;
import ssi2testbe.utils.ListMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jj")
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper, ListMapper listMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskListDto> taskListDtos = listMapper.mapList(tasks, TaskListDto.class, modelMapper);
        return ResponseEntity.ok(taskListDtos);
    }

//    @GetMapping
//    public ResponseEntity<Object> getAllTasks() {
//        List<Task> tasks = taskService.getAllTasks();
//        List<TaskListDto> taskListDtos = tasks.stream().map(entity -> modelMapper.map(entity, TaskListDto.class)).collect(Collectors.toList());
//        return ResponseEntity.ok(taskListDtos);
//    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Object> getTaskById(@PathVariable Integer taskId) {
        Task task = taskService.getTaskById(taskId);
        TaskListDto taskListDto = modelMapper.map(task, TaskListDto.class);
        return new ResponseEntity<Object>(task,HttpStatus.OK);
    }

    @PostMapping("/Naheeoat")
    public ResponseEntity<Object> test(@RequestBody Testdto testInput) {
        if (testInput.getName() == null){
            throw new ItemNotFoundException("");
        }
        return new ResponseEntity<Object>(testInput,HttpStatus.OK);
    }

    @GetMapping("/Xd")
    public ResponseEntity<Object> findAllTask(
            @RequestParam(defaultValue = "") String partOfTaskTitle,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] direction,
            @RequestParam(defaultValue = "0") @Min(0) int pageNo,
            @RequestParam(defaultValue = "10") @Min(10) @Max(20) int pageSize) {
        Page<Task> taskPage = taskService.getTasks(partOfTaskTitle,sortBy, direction, pageNo, pageSize);
        PageDTO<TaskListDto> pageDto = listMapper.toPageDTO(taskPage, TaskListDto.class, modelMapper);
        return ResponseEntity.ok(pageDto);
    }



}