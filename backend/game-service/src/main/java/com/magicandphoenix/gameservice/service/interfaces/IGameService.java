package com.magicandphoenix.gameservice.service.interfaces;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.model.Game;

import java.util.List;

public interface IGameService {

    //===============================
    //Get Methods
    //===============================
    List<GameDTO> getGameListByUserId(Long id);
    List<GameDTO> getGameListByMasterId(Long id);
    List<GameDTO> gameList();
    List<GameDTO> getGameListByName(String name);
    GameDTO getGameById(Long id);

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
