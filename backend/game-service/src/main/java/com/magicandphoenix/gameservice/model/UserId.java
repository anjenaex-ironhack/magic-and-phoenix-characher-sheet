package com.magicandphoenix.gameservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserId {

    @Id
    private Long id;

//    @ManyToMany (mappedBy = "userIdList")
//    @JsonIgnore
//    private List<Game> gameWithListDTOList;

    public UserId() {
    }

    public UserId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
