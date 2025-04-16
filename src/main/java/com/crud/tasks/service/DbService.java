package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(final Long id) throws TaskNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }

    public void deleteTask(Long taskId) throws TaskNotFoundException {
        repository.deleteById(taskId);

//                .deleteTaskById(taskId)
//                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + taskId));
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }
}