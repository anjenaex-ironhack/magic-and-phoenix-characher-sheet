package com.magicandphoenix.userServicedev.controller.impl;

import com.magicandphoenix.userServicedev.client.CharacterClient;
import com.magicandphoenix.userServicedev.controller.dto.CharacterDTO;
import com.magicandphoenix.userServicedev.controller.dto.PxDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private CharacterClient characterClient;

    //=======================================
    // Get Methods
    //=======================================

    //Get a character by id
    @GetMapping("character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return characterClient.getCharacterById(id);
    }

    //Get a character list by gameId
    @GetMapping("characters/game/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getCharacterListByGameId(@PathVariable Long gameId) {
        return characterClient.getCharacterListByGameId(gameId);
    }

    @GetMapping("characters/game/{gameId}/player/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getCharacterListByGameIdAndUserId(@PathVariable Long gameId, @PathVariable Long userId) {
        return characterClient.getCharacterListByGameIdAndUserId(gameId, userId);
    }

    //=======================================
    // Post Methods
    //=======================================

    //Create a new Character
    @PostMapping("character")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        characterClient.createCharacter(characterDTO);
    }

    //=======================================
    // Put Methods
    //=======================================

    //Update any field from a character by id
    @PutMapping("character/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void upgradeCharacterById(@PathVariable Long id, @RequestBody @Valid CharacterDTO characterDTO) {
        characterClient.upgradeCharacterById(id, characterDTO);
    }

    //=======================================
    // Patch Methods
    //=======================================

    //Update the px field from a character by id
    //TODO: this patch also doesn't work
    @PatchMapping("character/px/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePxById(@PathVariable Long id, @RequestBody @Valid PxDTO pxDTO) {
        characterClient.updatePxById(id, pxDTO);
    }

    //=======================================
    // Delete Methods
    //=======================================

    //Delete a character
    @DeleteMapping("character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        characterClient.deleteCharacter(id);
    }

}
