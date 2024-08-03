package com.app.config;

import com.app.dto.TaskDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class BeanConfig {

    @Bean
    @RequestScope
    public TaskDto taskDto() {
        return new TaskDto();
    }
}
