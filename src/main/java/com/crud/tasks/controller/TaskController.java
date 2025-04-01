package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTask(long taskId) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @DeleteMapping
    public void deleteTask(long id) {
        getTasks().remove(id);
    }

    @PostMapping
    public void createTask(TaskDto task) {
        getTasks().add(task);
    }

    @PatchMapping
    public TaskDto updateTask(TaskDto task) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }
}
