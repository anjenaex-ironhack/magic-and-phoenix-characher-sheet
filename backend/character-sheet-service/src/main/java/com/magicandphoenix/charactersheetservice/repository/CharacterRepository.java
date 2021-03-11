package com.magicandphoenix.charactersheetservice.repository;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.model.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByGameId(Long gameId);
}
