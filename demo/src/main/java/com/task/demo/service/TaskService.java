package com.task.demo.service;

import com.task.demo.dto.TaskDto;
import com.task.demo.entity.enums.TaskStatusEnum;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTasks();

    List<TaskDto> getAllTasksByEnum(TaskStatusEnum status);

    TaskDto getTaskById(Long id);

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);

    TaskDto markTaskAsCompleted(Long id);
}
