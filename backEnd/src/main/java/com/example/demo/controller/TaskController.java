package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/tasks")
public class TaskController {
    
    public TaskController(){}

    @PostMapping("/createTask")
    public boolean postMethodNam() {
        return true;
    }
    
}
