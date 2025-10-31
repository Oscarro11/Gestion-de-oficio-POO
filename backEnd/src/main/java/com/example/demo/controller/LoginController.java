package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.service.LoginService;
import com.example.demo.service.CookiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;
    private final CookiesService cookiesService;

    public LoginController(LoginService loginService, CookiesService cookiesService){
        this.loginService = loginService;
        this.cookiesService = cookiesService;
    }

    @PostMapping("/unvalidatedCreateUserAccount")
    public ResponseEntity<User> createUnvalidatedUser(@RequestBody UserResponseDTO userDTO){
        return ResponseEntity.ok(loginService.saveUserAccount(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail()));
    }

    @PostMapping("/createUserAccount")
    public ResponseEntity<Boolean> createValidatedUser(@RequestBody UserResponseDTO userDTO, HttpSession activeSession){
        User createdUser = loginService.createUserAccount(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        if (createdUser != null){
            cookiesService.setActiveUserId(activeSession, createdUser.getId());
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/findUserAccount")
    public ResponseEntity<Boolean> findUser(@RequestBody UserResponseDTO userDTO, HttpSession activeSession){
        User foundUser = loginService.findUserAccount(userDTO.getUsername(), userDTO.getPassword());
        if (foundUser != null){
            cookiesService.setActiveUserId(activeSession, foundUser.getId());
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.ok(false);
        }
        
    }
}
