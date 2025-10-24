package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/Main")
public class MainController {   
    private final UserService userService;

    public MainController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getActiveUserName")
    public ResponseEntity<String> getActiveUserName(HttpSession activeSession){
        UserDTO dto = getActiveUser(activeSession).getBody();
        return ResponseEntity.ok(dto.getUsername());
    }

    @GetMapping("/getActiveUser")
    public ResponseEntity<UserDTO> getActiveUser(HttpSession activeSession){

        User user =  userService.getUserById((long) activeSession.getAttribute("activeUserId"));
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return ResponseEntity.ok(dto);
    }   

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //This method should be removed once development is finished, as the active user cam only be set through login
    @PostMapping("/setActiveUser")
    public void postMethodName(HttpSession activeSession) {
        activeSession.setAttribute("activeUserId", (long) 1);
    }
    
    
}
