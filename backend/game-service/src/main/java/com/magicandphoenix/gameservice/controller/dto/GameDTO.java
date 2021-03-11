package com.magicandphoenix.gameservice.controller.dto;

import javax.validation.constraints.NotEmpty;

public class GameDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private Long masterId;

    public GameDTO() {
    }

    public GameDTO(@NotEmpty String name, @NotEmpty Long masterId) {
        setName(name);
        setMasterId(masterId);
    }

    public String getName() {
        return name;
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
}
