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


@RestController
public class CharacterController implements ICharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping("/character-sheet/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }
    @PostMapping("/character-sheet")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.createCharacter(characterDTO);
    }

    @PutMapping("/character-sheet/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character upgradeCharacterById(@PathVariable Long id, @RequestBody @Valid CharacterDTO characterDTO) {
        return characterService.upgradeCharacterById(id, characterDTO);
    }

    @PatchMapping("/character-sheet/px/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Character updatePxById(@PathVariable Long id, @RequestBody @Valid PxDTO pxDTO) {
        return characterService.updatePxById(id, pxDTO);
    }
    @DeleteMapping("/character-sheet/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
