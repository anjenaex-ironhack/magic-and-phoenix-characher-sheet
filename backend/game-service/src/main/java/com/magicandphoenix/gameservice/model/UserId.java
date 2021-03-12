package com.magicandphoenix.gameservice.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserId {

    @Id
    private Long id;

    @ManyToMany (mappedBy = "userIdList")
    private List<Game> gameWithListDTOList;

    public UserId() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Game> getGameList() {
        return gameWithListDTOList;
    }

    public void setGameList(List<Game> gameWithListDTOList) {
        this.gameWithListDTOList = gameWithListDTOList;
    }
}
