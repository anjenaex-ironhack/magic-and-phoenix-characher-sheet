package com.magicandphoenix.charactersheetservice.repository;

import com.magicandphoenix.charactersheetservice.model.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
