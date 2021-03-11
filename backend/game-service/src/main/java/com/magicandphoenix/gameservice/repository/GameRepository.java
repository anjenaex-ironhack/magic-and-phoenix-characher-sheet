package com.magicandphoenix.gameservice.repository;

import com.magicandphoenix.gameservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    //Get a list with all the games with a specific userId
    List<Game> findByUserId(Long userId);
    List<Game> findByName (String name);

}
