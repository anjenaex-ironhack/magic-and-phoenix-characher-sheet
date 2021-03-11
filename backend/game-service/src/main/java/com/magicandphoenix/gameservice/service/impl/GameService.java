package com.magicandphoenix.gameservice.service.impl;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.repository.GameRepository;
import com.magicandphoenix.gameservice.service.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;


    public List<GameDTO> getGameListByUserId(Long userId) {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findByUserId(userId)){
            GameDTO gameDTO =  new GameDTO(game.getName(), game.getMasterId());
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;
    }

    public List<GameDTO> gameList() {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findAll()){
            GameDTO gameDTO =  new GameDTO(game.getName(), game.getMasterId());
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;
    }

    public List<GameDTO> getGameListByName(String name) {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findByName(name)){
            GameDTO gameDTO =  new GameDTO(game.getName(), game.getMasterId());
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;

    }

    public GameDTO getGameById(Long id) {

        if(gameRepository.findByUserId(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "game with id " + id + " not found");
        }else{
            Game game = gameRepository.findById(id).get();
            GameDTO gameDTO = new GameDTO(game.getName(), game.getMasterId());
            return gameDTO;
        }
    }


    public Game createGame(GameDTO gameDTO) {
        return null;
    }

    public Game addNewPlayer(UserDTO userDTO) {
        return null;
    }
}
