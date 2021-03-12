package com.magicandphoenix.gameservice.controller.interfaces;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.model.Game;

import java.util.List;

public interface IGameController {

    //===============================
    //Get Methods
    //===============================
    GameDTO getGameById(Long id);
    List<GameDTO> gameList();
    List<GameWithListsDTO> getGameListByName(String name);
    List<GameDTO> getGameListByUserId(Long id);
    List<GameDTO> getGameListByMasterId(Long id);


    //===============================
    //Post Methods
    //===============================
    Game createGame(GameDTO gameDTO);

    //===============================
    //Patch Methods
    //===============================
    Game addNewPlayer(UserDTO userDTO);

    //===============================
    //Put Methods
    //===============================

    //===============================
    //Delete Methods
    //===============================

}
