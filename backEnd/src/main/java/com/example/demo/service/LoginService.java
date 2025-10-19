package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUserAccount(String username, String password, String email){
        List<User> usuarios = userRepository.findAll();
        boolean used_mail = false;

        for (User user: usuarios){
            if (user.getEmail().equals(email)){
                used_mail = true;
                break;
            }
        }

        if (used_mail){
            return null;
        }
        else{
            User createdUser = saveUserAccount(username, password, email);;
            return createdUser;
        }
    }

    public User findUserAccount(String name, String password){
        List<User> usuarios = userRepository.findAll();

        for (User user: usuarios){
            if (user.getUsername().equals(name) && user.getPassword().equals(password)){
                return user;
            }
        }

        return null;
    }

    public User saveUserAccount(String username, String password, String email){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }
}
