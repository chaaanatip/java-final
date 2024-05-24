package com.example.backendtest.model;

import org.springframework.context.annotation.Bean;

public class Task {
    @Bean
    public Task task() {
        return new Task();
    }
}
