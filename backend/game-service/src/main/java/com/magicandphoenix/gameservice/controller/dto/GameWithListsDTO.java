package com.magicandphoenix.gameservice.controller.dto;

import com.magicandphoenix.gameservice.model.UserId;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class GameWithListsDTO {

    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Long masterId;
    private List<UserId> userId;

}
