package com.magicandphoenix.userServicedev.controller.impl;

import com.magicandphoenix.userServicedev.client.GameClient;
import com.magicandphoenix.userServicedev.controller.dto.GameDTO;
import com.magicandphoenix.userServicedev.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping("/api")
public class GameController {
    @Autowired
    private GameClient gameClient;

    //=======================================
    // Get Methods
    //=======================================

    //Find all games
    @GetMapping("games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> gameList() {
        return gameClient.gameList();
    }

    //Game List by game name
    @GetMapping("games/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByName(@PathVariable String name) {
        return gameClient.getGameListByName(name);
    }

    //Game list by user id
    @GetMapping("games/user-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByUserId(@PathVariable Long id) {
        return gameClient.getGameListByUserId(id);
    }

    //Game list by master id
    @GetMapping("games/master-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDTO> getGameListByMasterId(@PathVariable Long id) {
        return gameClient.getGameListByMasterId(id);
    }

    //game by id
    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameDTO getGameById(@PathVariable Long id) {

        return gameClient.getGameById(id);
    }

    //=======================================
    // Post Methods
    //=======================================

    //Create a new game
    @PostMapping("game")
    @ResponseStatus(HttpStatus.CREATED)
    public GameDTO createGame(@RequestBody GameDTO gameDTO) {
        return gameClient.createGame(gameDTO);
    }


    //=======================================
    // Patch Methods
    //=======================================

    //add a new user to the game
    //TODO: This one doesn't work, check why
    @PatchMapping("game/{gameId}/add-player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addNewPlayer(@PathVariable Long gameId, @RequestBody UserDTO userDTO) {
        gameClient.addNewPlayer(gameId,userDTO);
    }

    //=======================================
    // Delete Methods
    //=======================================

    //delete a game
    @DeleteMapping("game/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long gameId) {
        gameClient.deleteGame(gameId);
    }
}
