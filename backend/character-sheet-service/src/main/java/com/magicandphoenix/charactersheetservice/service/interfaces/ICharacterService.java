package com.magicandphoenix.charactersheetservice.service.interfaces;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.controller.dto.PxDTO;
import com.magicandphoenix.charactersheetservice.model.Character;


public interface ICharacterService {

    //Get Method
    CharacterDTO getCharacterById(Long id);
    //Post Method
    Character createCharacter(CharacterDTO characterDTO);
    //Patch Method
    Character updatePxById(Long id, PxDTO pxDTO);
    //Put Method
    Character upgradeCharacterById(Long id, CharacterDTO characterDTO);
    //Delete Method
    void deleteCharacter(Long id);

}
