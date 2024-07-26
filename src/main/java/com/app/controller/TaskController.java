package com.app.controller;

import com.app.dto.TaskDto;
import com.app.entity.Task;
import com.app.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteTask(@Valid @RequestParam(name = "id") Long taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Task> getTask(@Valid @PathVariable(name = "id") Long taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

}
