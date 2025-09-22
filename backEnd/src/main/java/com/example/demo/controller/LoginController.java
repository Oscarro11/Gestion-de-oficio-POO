package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.LoginService;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/unvalidatedCreateUserAccount")
    public User createUnvalidatedUser(@RequestBody UserDTO userDTO){
        return loginService.saveUserAccount(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
    }

    @PostMapping("/createUserAccount")
    public boolean createValidatedUser(@RequestBody UserDTO userDTO, HttpSession activeSession){
        User createdUser = loginService.createUserAccount(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
        if (createdUser != null){
            storeUserId(activeSession, createdUser.getId());
            return true;
        }
        else{
            return false;
        }
    }

    @PostMapping("/findUserAccount")
    public boolean findUser(@RequestBody UserDTO userDTO, HttpSession activeSession){
        User foundUser = loginService.findUserAccount(userDTO.getUsername(), userDTO.getPassword());
        if (foundUser != null){
            storeUserId(activeSession, foundUser.getId());
            return true;
        }
        else{
            return false;
        }
        
    }

    private static void storeUserId(HttpSession session, Long id){
        session.setAttribute("activeUserId", id);
    }
}
