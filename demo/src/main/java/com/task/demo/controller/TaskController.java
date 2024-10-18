package com.task.demo.controller;

import com.task.demo.dto.TaskDto;
import com.task.demo.entity.enums.TaskStatusEnum;
import com.task.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        TaskDto savedTaskDto = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(@RequestParam(required = false) TaskStatusEnum status){
        List<TaskDto> taskDtos;
        if(status == null){
            taskDtos = taskService.getAllTasks();
        } else{
            taskDtos = taskService.getAllTasksByEnum(status);
        }
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        TaskDto taskDto = taskService.getTaskById(id);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto){
        TaskDto updatedTaskDto = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(updatedTaskDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully!!", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskDto> markTaskAsCompleted(@PathVariable Long id){
        TaskDto taskDto = taskService.markTaskAsCompleted(id);
        return ResponseEntity.ok(taskDto);
    }
}
