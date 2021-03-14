package com.magicandphoenix.userServicedev.controller.dto;

import com.magicandphoenix.userServicedev.model.User;

public class UserDTO {

    private String username;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public UserDTO(User user) {
        setUsername(user.getUsername());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
