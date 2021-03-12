package com.magicandphoenix.gameservice.service.impl;

import com.magicandphoenix.gameservice.controller.dto.GameDTO;
import com.magicandphoenix.gameservice.controller.dto.GameWithListsDTO;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.model.UserId;
import com.magicandphoenix.gameservice.repository.GameRepository;
import com.magicandphoenix.gameservice.repository.UserIdRepository;
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

    @Autowired
    private UserIdRepository userIdRepository;

    public List<GameDTO> getGameListByUserId(Long id) {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findGameByUserId(id)){
            GameDTO gameDTO =  new GameDTO(game);
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;
    }

    public List<GameDTO> getGameListByMasterId(Long id) {
        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findByMasterId(id)){
            GameDTO gameDTO =  new GameDTO(game);
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;
    }

    public List<GameDTO> gameList() {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findAll()){
            GameDTO gameDTO =  new GameDTO(game);
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;
    }

    public List<GameDTO> getGameListByName(String name) {

        List<GameDTO> gameDTOList = new ArrayList<>();

        for( Game game: gameRepository.findByName(name)){
            GameDTO gameDTO =  new GameDTO(game);
            gameDTOList.add(gameDTO);
        }

        return gameDTOList;

    }

    public GameDTO getGameById(Long id) {

        if(gameRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "game with id " + id + " not found");
        }else{
            Game game = gameRepository.findById(id).get();
            GameDTO gameDTO = new GameDTO(game);
            return gameDTO;
        }
    }


    public GameDTO createGame(GameDTO gameDTO) {

        Game game = new Game(gameDTO);
        gameRepository.save(game);

        return gameDTO;
    }

    public Game addNewPlayer(Long gameId, UserDTO userDTO) {
        //Check if the game exist
        if(gameRepository.findById(gameId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "game with id " + gameId + " not found");
        }else{
            //TODO: aqui tengo que meter una llama al servicio usuarios para ver si existe, y si no existe no hacer la operación
            //If the userId is not in the database, it will be added
            UserId userId = new UserId(userDTO.getUserId());
            if(userIdRepository.findById(userDTO.getUserId()).isEmpty()){
                userIdRepository.save(userId);
            }
            Game game = gameRepository.findById(gameId).get();

            //If the game already have the user id, we get a bad request
            if(game.getUserIdList().contains(userIdRepository.findById(userDTO.getUserId()).get())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the game with id "+
                          gameId + "already have the userId " + userDTO.getUserId());
            }else{
                //update the data
                game.getUserIdList().add(userIdRepository.findById(userDTO.getUserId()).get());
                gameRepository.save(game);
                return game;
            }
        }
    }

    public void deleteGame(Long gameId) {
        if(gameRepository.findById(gameId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "game with id " + gameId + " not found");
        }else{
            Game game = gameRepository.findById(gameId).get();
            gameRepository.delete(game);

        }
    }
}
