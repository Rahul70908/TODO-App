package com.app.service;

import com.app.dto.TaskDto;
import com.app.entity.Task;
import com.app.exception.TodoException;
import com.app.mappers.TodoMappers;
import com.app.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TodoMappers todoMappers;

    public Task createTask(TaskDto taskDto) {
        var task = todoMappers.mapTaskDtoToEntity(taskDto);
        return taskRepository.save(task);
    }

    public Task updateTask(TaskDto taskDto) {
        Task task;
        if (taskRepository.existsById(taskDto.getId())) {
            task = todoMappers.mapTaskDtoToEntity(taskDto);
        } else {
            throw new TodoException("Task not found");
        }
        return taskRepository.save(task);
    }

    public String deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new TodoException("Task not found");
        }
        return "Task deleted successfully";
    }

    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TodoException("Task not found"));
        return todoMappers.mapToTask(task);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
}
