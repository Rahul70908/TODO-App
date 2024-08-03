package com.app.exception.handler;

import com.app.exception.TodoException;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ext) {
       return "redirect:/task/getAll";
    }

    @ExceptionHandler(value = TodoException.class)
    public ResponseEntity<String> handleTodoException(TodoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
