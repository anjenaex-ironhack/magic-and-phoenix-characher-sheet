package com.magicandphoenix.userServicedev.controller.dto;


import javax.validation.constraints.NotEmpty;

public class GameDTO {

    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Long masterId;
    @NotEmpty
    private String token;

    public GameDTO() {
    }

    public GameDTO(@NotEmpty String name, @NotEmpty Long masterId, @NotEmpty String token) {
        setName(name);
        setMasterId(masterId);
        setToken(token);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
