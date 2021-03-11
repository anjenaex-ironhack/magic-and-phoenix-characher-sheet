package com.magicandphoenix.gameservice.controller.impl;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.controller.interfaces.IGameController;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements IGameController {

    @Autowired
    private IGameService gameService;

    public List<GameWithListsDTO> getGameListByUserId(Long userId) {
        return null;
    }

    public List<GameWithListsDTO> gameList() {
        return null;
    }

    public List<GameWithListsDTO> getGameListByName(String name) {
        return null;
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
