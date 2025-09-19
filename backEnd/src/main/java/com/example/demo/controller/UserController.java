package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO.getName(), userDTO.getPassword());
    }

    @GetMapping("/getUsers")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }
}
