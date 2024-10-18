package com.task.demo.service.impl;

import com.task.demo.dto.TaskDto;
import com.task.demo.entity.Task;
import com.task.demo.entity.enums.TaskStatusEnum;
import com.task.demo.mapper.TaskMapper;
import com.task.demo.repository.TaskRepository;
import com.task.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task savedTask = taskRepository.save(TaskMapper.mapToTask(taskDto));
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(TaskMapper::mapToTaskDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllTasksByEnum(TaskStatusEnum status) {
        List<Task> tasks = taskRepository.findAllTasksByStatus(status);
        List<TaskDto> taskDtos = tasks.stream().map(TaskMapper::mapToTaskDto).toList();
        return taskDtos;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        TaskDto taskDto = taskRepository.findById(id)
                .map(TaskMapper::mapToTaskDto)
                .orElseThrow(() -> new RuntimeException("Task does not exists!!"));
        return taskDto;
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setDueDate(taskDto.getDueDate());
            task.setStatus(taskDto.getStatus());
            taskRepository.save(task);
            return TaskMapper.mapToTaskDto(task);
        }).orElseThrow(() -> new RuntimeException("Task does not exists to update!!"));
    }

    @Override
    public void deleteTask(Long id) {
            taskRepository.deleteById(id);
    }

    @Override
    public TaskDto markTaskAsCompleted(Long id) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(TaskStatusEnum.COMPLETED);
            taskRepository.save(task);
            return TaskMapper.mapToTaskDto(task);
        }).orElseThrow(() -> new RuntimeException("Task does not exists!!"));
    }

}
