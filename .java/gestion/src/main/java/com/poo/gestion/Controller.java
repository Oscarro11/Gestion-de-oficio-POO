package com.poo.gestion;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class Controller {
    @CrossOrigin
    @PostMapping("/api/sign-up")
    public String signUp(@RequestBody SignUp signUp) {
        SignUp user = signUp;
        return user.crearCuenta();
    }
}
