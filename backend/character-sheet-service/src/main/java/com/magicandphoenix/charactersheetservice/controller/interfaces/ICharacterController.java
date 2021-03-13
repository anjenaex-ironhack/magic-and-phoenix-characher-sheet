package com.magicandphoenix.charactersheetservice.controller.interfaces;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.controller.dto.PxDTO;
import com.magicandphoenix.charactersheetservice.model.Character;

import java.util.List;


public interface ICharacterController {

    //Get Method
    CharacterDTO getCharacterById(Long id);
    //Get Method
    List<CharacterDTO> getCharacterListByGameId(Long gameId);
    //Get Method
    List<CharacterDTO> getCharacterListByGameIdAndUserId(Long gameId, Long userId);
    //Post Method
    Character createCharacter(CharacterDTO characterDTO);
    //Put Method
    Character upgradeCharacterById(Long id, CharacterDTO characterDTO);
    //Patch Method
    Character updatePxById(Long id, PxDTO pxDTO);
    //Delete Method
    void deleteCharacter(Long id);


}
