package com.magicandphoenix.gameservice.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserIdList {

    private Long id;

    @ManyToMany (mappedBy = "userIdList")
    private List<Game> gameList;

    public UserIdList() {
    }

    public UserIdList(Long id) {
        setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
