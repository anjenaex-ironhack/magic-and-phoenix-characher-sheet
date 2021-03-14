package com.magicandphoenix.userServicedev.client;

import com.magicandphoenix.userServicedev.controller.dto.CharacterDTO;
import com.magicandphoenix.userServicedev.controller.dto.PxDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("characterSheetService-dev")
public interface CharacterClient {

    //=======================================
    // Get Methods
    //=======================================

   @GetMapping("character/{id}")
    @ResponseStatus(HttpStatus.OK)
    CharacterDTO getCharacterById(@PathVariable Long id);

    //Get a character list by gameId
    @GetMapping("characters/game/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    List<CharacterDTO> getCharacterListByGameId(@PathVariable Long gameId);

    @GetMapping("characters/game/{gameId}/player/{userId}")
    @ResponseStatus(HttpStatus.OK)
    List<CharacterDTO> getCharacterListByGameIdAndUserId(@PathVariable Long gameId, @PathVariable Long userId);

    //=======================================
    // Post Methods
    //=======================================

    //Create a new Character
    @PostMapping("character")
    @ResponseStatus(HttpStatus.CREATED)
    void createCharacter(@RequestBody @Valid CharacterDTO characterDTO);

    //=======================================
    // Put Methods
    //=======================================

    //Update any field from a character by id
    @PutMapping("character/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void upgradeCharacterById(@PathVariable Long id, @RequestBody @Valid CharacterDTO characterDTO);

    //=======================================
    // Patch Methods
    //=======================================

    //Update the px field from a character by id
    @PatchMapping("character/px/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updatePxById(@PathVariable Long id, @RequestBody @Valid PxDTO pxDTO);

    //=======================================
    // Delete Methods
    //=======================================

    //Delete a character
    @DeleteMapping("character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id);

}
