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
    private String token;

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
        setToken(gameDTO.getToken());
    }

    public Game(String name, Long masterId, String token) {
        setName(name);
        setMasterId(masterId);
        setToken(token);
    }

    public Game(String name, Long masterId,String token,  List<UserId> userIdList) {
        setName(name);
        setMasterId(masterId);
        setToken(token);
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
