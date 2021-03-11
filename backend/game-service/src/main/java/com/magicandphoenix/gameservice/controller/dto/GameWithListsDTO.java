package com.magicandphoenix.gameservice.controller.dto;

import com.magicandphoenix.gameservice.model.UserIdList;
import reactor.util.annotation.NonNull;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class GameWithListsDTO {

    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Long masterId;
    private List<UserIdList> userIdList;

}
