package com.example.demo.controller;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.CookiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/Main")
public class MainController {   
    private final UserService userService;
    private final CookiesService cookiesService;

    public MainController(UserService userService, CookiesService cookiesService){
        this.userService = userService;
        this.cookiesService = cookiesService;
    }

    @GetMapping("/getActiveUserName")
    public ResponseEntity<String> getActiveUserName(HttpSession activeSession){
        UserResponseDTO dto = getActiveUser(activeSession).getBody();
        return ResponseEntity.ok(dto.getUsername());
    }

    @GetMapping("/getActiveUser")
    public ResponseEntity<UserResponseDTO> getActiveUser(HttpSession activeSession){

        User user =  userService.getUserById(cookiesService.getActiveUserId(activeSession));
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return ResponseEntity.ok(dto);
    }   

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        List<User> user = userService.getAllUsers();
        List<UserResponseDTO> newDtos = new ArrayList<UserResponseDTO>();

        for (User u : user){
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(u.getId());
            dto.setUsername(u.getUsername());
            dto.setEmail(u.getEmail());
            dto.setPassword(u.getPassword());
            newDtos.add(dto);
        }

        return ResponseEntity.ok(newDtos);
    }
    
    
}
