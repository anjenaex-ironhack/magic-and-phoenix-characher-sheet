package com.magicandphoenix.gameservice.repository;

import com.magicandphoenix.gameservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    //Get a list with all the games with a specific userId
    @Query("SELECT DISTINCT g FROM Game g JOIN g.userIdList u WHERE u.id = :id")
    List<Game> findGameByUserId(@Param("id") Long id);
    //Get a list with all the game with a specific masterId
    List<Game> findByMasterId(Long masterId);
    //Get a list of games with an specific name
    List<Game> findByName (String name);

}
