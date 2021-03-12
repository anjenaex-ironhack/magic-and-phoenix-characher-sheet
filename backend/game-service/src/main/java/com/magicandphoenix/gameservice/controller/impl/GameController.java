package com.magicandphoenix.gameservice.controller.impl;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.controller.interfaces.IGameController;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
public class GameController implements IGameController {

    @Autowired
    private IGameService gameService;


    @GetMapping("games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> gameList() {
        return gameService.gameList();
    }

    public List<GameWithListsDTO> getGameListByName(String name) {
        return null;
    }

    @GetMapping("games/user-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByUserId(@PathVariable Long id) {
        return gameService.getGameListByUserId(id);
    }

    @GetMapping("games/master-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByMasterId(@PathVariable Long id) {
        return gameService.getGameListByMasterId(id);
    }

    public GameDTO getGameById(Long id) {
        return null;
    }

    public Game createGame(GameDTO gameDTO) {
        return null;
    }

    public Game addNewPlayer(UserDTO userDTO) {
        return null;
    }
}
