package com.magicandphoenix.userServicedev.client;

import com.magicandphoenix.userServicedev.controller.dto.GameDTO;
import com.magicandphoenix.userServicedev.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("gameService-dev")
public interface GameClient {


    //=======================================
    // Get Methods
    //=======================================

    //Find all games
    @GetMapping("games")
    List<GameDTO> gameList();

    //Game List by game name
    @GetMapping("games/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    List<GameDTO> getGameListByName(@PathVariable String name);

    //Game list by user id
    @GetMapping("games/user-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<GameDTO> getGameListByUserId(@PathVariable Long id);

    //Game list by master id
    @GetMapping("games/master-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<GameDTO> getGameListByMasterId(@PathVariable Long id);

    //game by id
    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    GameDTO getGameById(@PathVariable Long id);

    //=======================================
    // Post Methods
    //=======================================

    //Create a new game
    @PostMapping("game")
    @ResponseStatus(HttpStatus.CREATED)
    GameDTO createGame(@RequestBody GameDTO gameDTO);


    //=======================================
    // Patch Methods
    //=======================================

    //add a new user to the game
    @PatchMapping("game/{gameId}/add-player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addNewPlayer(@PathVariable Long gameId, @RequestBody UserDTO userDTO);

    //=======================================
    // Delete Methods
    //=======================================

    //delete a game
    @DeleteMapping("game/{gameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Long gameId);

}
