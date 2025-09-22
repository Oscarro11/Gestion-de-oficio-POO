package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;


@RestController
@RequestMapping("/api/Main")
public class MainController {   
    private final UserService userService;

    public MainController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getActiveUserName")
    public String getActiveUserName(HttpSession activeSession){
        UserDTO dto = getActiveUser(activeSession);
        return dto.getUsername();
    }

    @GetMapping("/getActiveUser")
    public UserDTO getActiveUser(HttpSession activeSession){

        User user =  userService.getUserById((Long) activeSession.getAttribute("activeUserId"));
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }   

    @GetMapping("/getUsers")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }
    
}
