package com.poo.gestion;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @PostMapping("/api/sign-up")
    public String signUp(@RequestBody SignUp signUp) {
        SignUp user = signUp;
        return user.crearCuenta();
    }

    // GET, POST, PUT/PATCH, DELETE
    @GetMapping("/api/hello")
    public String getMethodName() {
        return "Hello, world! ";
    }

}
