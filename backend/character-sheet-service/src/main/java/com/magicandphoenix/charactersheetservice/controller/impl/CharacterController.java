package com.magicandphoenix.charactersheetservice.controller.impl;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.controller.dto.PxDTO;
import com.magicandphoenix.charactersheetservice.controller.interfaces.ICharacterController;
import com.magicandphoenix.charactersheetservice.service.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.magicandphoenix.charactersheetservice.model.Character;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("**")
public class CharacterController implements ICharacterController {

    @Autowired
    private ICharacterService characterService;

    //=======================================
    // Get Methods
    //=======================================

    //Get a character by id
    @GetMapping("character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    //Get a character list by gameId
    @GetMapping("characters/game/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getCharacterListByGameId(@PathVariable Long gameId) {
        return characterService.getCharacterListByGameId(gameId);
    }

    //=======================================
    // Post Methods
    //=======================================

    //Create a new Character
    @PostMapping("character")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.createCharacter(characterDTO);
    }

    //=======================================
    // Put Methods
    //=======================================

    //Update any field from a character by id
    @PutMapping("character/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character upgradeCharacterById(@PathVariable Long id, @RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.upgradeCharacterById(id, characterDTO);
    }

    //=======================================
    // Patch Methods
    //=======================================

    //Update the px field from a character by id
    @PatchMapping("character/px/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character updatePxById(@PathVariable Long id, @RequestBody @Valid PxDTO pxDTO) {
        return characterService.updatePxById(id, pxDTO);
    }

    //=======================================
    // Delete Methods
    //=======================================

    //Delete a character
    @DeleteMapping("character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
