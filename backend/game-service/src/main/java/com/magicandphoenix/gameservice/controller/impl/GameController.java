package com.magicandphoenix.gameservice.controller.impl;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.controller.interfaces.IGameController;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
public class GameController implements IGameController {

    @Autowired
    private IGameService gameService;

    //=======================================
    // Get Methods
    //=======================================

    //Find all games
    @GetMapping("games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> gameList() {
        return gameService.gameList();
    }

    //Game List by game name
    @GetMapping("games/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByName(@PathVariable String name) {
        return gameService.getGameListByName(name);
    }

    //Game list by user id
    @GetMapping("games/user-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByUserId(@PathVariable Long id) {
        return gameService.getGameListByUserId(id);
    }

    //Game list by master id
    @GetMapping("games/master-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByMasterId(@PathVariable Long id) {
        return gameService.getGameListByMasterId(id);
    }

    //game by id
    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDTO getGameById(@PathVariable Long id) {

        return gameService.getGameById(id);
    }

    //=======================================
    // Post Methods
    //=======================================

    //Create a new game
    @PostMapping("game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody GameDTO gameDTO) {
        return gameService.createGame(gameDTO);
    }


    //=======================================
    // Patch Methods
    //=======================================

    //add a new user to the game
    @PatchMapping("game/{gameId}/add-player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game addNewPlayer(@PathVariable Long gameId, @RequestBody UserDTO userDTO) {
        return gameService.addNewPlayer(gameId,userDTO);
    }

    //=======================================
    // Delete Methods
    //=======================================

    //delete a game
    @DeleteMapping("game/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long gameId) {
        gameService.deleteGame(gameId);
    }
}
