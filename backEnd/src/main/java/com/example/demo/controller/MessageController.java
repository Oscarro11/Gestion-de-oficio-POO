package com.example.demo.controller;

import com.example.demo.dto.MessageDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {
    
    @PostMapping("/message")
    public String receiveMessage(@RequestBody MessageDTO message){
        return "You sent: " + message.getText();
    }
}
