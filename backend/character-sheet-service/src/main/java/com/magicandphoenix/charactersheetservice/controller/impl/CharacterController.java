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
public class CharacterController implements ICharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping("/character{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping("characters/game/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDTO> getCharacterListByGameId(@PathVariable Long gameId) {
        return characterService.getCharacterListByGameId(gameId);
    }

    @PostMapping("/character")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.createCharacter(characterDTO);
    }

    @PutMapping("/character/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character upgradeCharacterById(@PathVariable Long id, @RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.upgradeCharacterById(id, characterDTO);
    }

    @PatchMapping("/character/px/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character updatePxById(@PathVariable Long id, @RequestBody @Valid PxDTO pxDTO) {
        return characterService.updatePxById(id, pxDTO);
    }
    @DeleteMapping("/character/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
