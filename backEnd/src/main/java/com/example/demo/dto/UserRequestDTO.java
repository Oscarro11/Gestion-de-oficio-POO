package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestDTO {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;


    public UserRequestDTO() {}

    public UserRequestDTO(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
