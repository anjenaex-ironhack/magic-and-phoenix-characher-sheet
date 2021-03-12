package com.magicandphoenix.userServicedev.controller.dto;

import com.magicandphoenix.userServicedev.model.User;

public class UserDTO {

    private String name;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public UserDTO(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
