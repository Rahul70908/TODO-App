package com.app.controller;

import com.app.dto.TaskDto;
import com.app.service.TaskService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @SneakyThrows
    @PostMapping(path = "/create")
    public void createTask(@Valid @ModelAttribute(name = "task") TaskDto taskDto,
                           HttpServletResponse response) {
        taskService.createTask(taskDto);
        response.sendRedirect("/todo/task/getAll");
    }

    @SneakyThrows
    @PutMapping(path = "/update/{id}")
    public void updateTask(@PathVariable Long id, @Valid @ModelAttribute("task") TaskDto taskDto,
                           HttpServletResponse response) {
        taskService.updateTask(taskDto);
        response.sendRedirect("/todo/task/getAll");
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteTask(@Valid @RequestParam(name = "id") Long taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<TaskDto> getTask(@Valid @PathVariable(name = "id") Long taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @GetMapping(path = "/getAll")
    public String getTask(Model model) {
        model.addAttribute("tasks", taskService.getAllTask());
        return "task";
    }
}
