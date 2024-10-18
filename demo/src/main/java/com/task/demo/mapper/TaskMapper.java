package com.task.demo.mapper;

import com.task.demo.dto.TaskDto;
import com.task.demo.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task){
        TaskDto taskDto = new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(), task.getStatus());
        return taskDto;
    }

    public static Task mapToTask(TaskDto taskDto){
        Task task = new Task(taskDto.getId(), taskDto.getTitle(), taskDto.getDescription(), taskDto.getDueDate(), taskDto.getStatus());
        return task;
    }
}
