package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {

    private Long id;

    @NotBlank(message = "Task name cannot be blank")
    private String taskName;

    private String description;

    private String taskStatus;
}
