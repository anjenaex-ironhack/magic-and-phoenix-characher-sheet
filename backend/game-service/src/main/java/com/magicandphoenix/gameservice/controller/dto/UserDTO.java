package com.magicandphoenix.gameservice.controller.dto;

import javax.validation.constraints.NotEmpty;

public class UserDTO {

    @NotEmpty
    private Long userId;

    public UserDTO() {
    }

    public UserDTO(@NotEmpty Long userId) {
        setUserId(userId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
