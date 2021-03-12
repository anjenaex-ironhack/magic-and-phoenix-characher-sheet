package com.magicandphoenix.gameservice.model;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long masterId;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name="game_has_user_list",
            joinColumns = { @JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<UserId> userIdList;


    public Game() {
    }

    public Game(GameDTO gameDTO){
        setName(gameDTO.getName());
        setMasterId(gameDTO.getMasterId());
    }

    public Game(String name, Long masterId) {
        setName(name);
        setMasterId(masterId);
    }

    public Game(String name, Long masterId, List<UserId> userIdList) {
        setName(name);
        setMasterId(masterId);
        setUserIdList(userIdList);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public List<UserId> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<UserId> userIdList) {
        this.userIdList = userIdList;
    }

}
