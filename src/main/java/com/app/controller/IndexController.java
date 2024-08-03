package com.app.controller;

import com.app.dto.TaskDto;
import com.app.service.TaskService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final TaskDto taskDto;
    private final TaskService taskService;

    @GetMapping(path = "/createNew")
    public String createTask(Model model) {
        model.addAttribute("task", taskDto);
        return "create_task";
    }

    @GetMapping(path = "/edit/{id}")
    public String editTask(@PathVariable Long id, Model model, HttpServletResponse response) {
        model.addAttribute("task", taskService.getTask(id));
        return "edit_task";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model, HttpServletResponse response) {
        taskService.deleteTask(id);
        return "redirect:/task/getAll";
    }
}
