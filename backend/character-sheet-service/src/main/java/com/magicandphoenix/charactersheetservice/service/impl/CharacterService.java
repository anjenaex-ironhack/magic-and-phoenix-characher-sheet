package com.magicandphoenix.charactersheetservice.service.impl;

import com.magicandphoenix.charactersheetservice.enums.Country;
import com.magicandphoenix.charactersheetservice.enums.Profession;
import com.magicandphoenix.charactersheetservice.enums.RacialLineage;
import com.magicandphoenix.charactersheetservice.model.Character;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.controller.dto.PxDTO;
import com.magicandphoenix.charactersheetservice.repository.CharacterRepository;
import com.magicandphoenix.charactersheetservice.service.interfaces.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO getCharacterById(Long id) {

        Optional<Character> character = characterRepository.findById(id);
        CharacterDTO characterDTO;

        if(character.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character with id " +id+ " not found");
        }else{
            characterDTO = new CharacterDTO(character.get());
        }

        return characterDTO;
    }

    public List<CharacterDTO> getCharacterListByGameId(Long gameId) {

        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for(Character character: characterRepository.findByGameId(gameId)) {
            CharacterDTO characterDTO =  new CharacterDTO(character);
            characterDTOList.add(characterDTO);
        }

        return characterDTOList;
    }

    public List<CharacterDTO> getCharacterListByGameIdAndUserId(Long gameId, Long userId) {
        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for(Character character: characterRepository.findByGameIdAndUserId(gameId, userId)) {
            CharacterDTO characterDTO =  new CharacterDTO(character);
            characterDTOList.add(characterDTO);
        }

        return characterDTOList;
    }


    public Character createCharacter(CharacterDTO characterDTO) {

        try{
            Character character = new Character(characterDTO);
            characterRepository.save(character);
            return character;

        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Bad characterDTO provided");
        }

    }

    public Character updatePxById (Long id, PxDTO pxDTO) {

        Optional<Character> character = characterRepository.findById(id);

        if(character.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character with id " +id+ " not found");
        }{
            character.get().setPx(character.get().getPx() + pxDTO.getPx());
            characterRepository.save(character.get());
            return character.get();
        }

    }

    public Character upgradeCharacterById(Long id, CharacterDTO characterDTO) {
        Optional<Character> character = characterRepository.findById(id);

        if(character.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character with id " +id+ " not found");
        }{
            //basic info
            character.get().setName(characterDTO.getName());
            character.get().setRacialLineage(RacialLineage.valueOf(characterDTO.getRacialLineage().toUpperCase()));
            character.get().setCountry(Country.valueOf(characterDTO.getCountry().toUpperCase()));
            character.get().setProfession(Profession.valueOf(characterDTO.getProfession().toUpperCase()));
            character.get().setPx(characterDTO.getPx());

            //Attributes
            character.get().setPhysical(characterDTO.getPhysical());
            character.get().setSkill(characterDTO.getSkill());
            character.get().setMental(characterDTO.getMental());
            character.get().setSocial(characterDTO.getSocial());

            //Basic skills
            character.get().setAthletics(characterDTO.getAthletics());
            character.get().setKnowledge(characterDTO.getKnowledge());
            character.get().setInterpretation(characterDTO.getInterpretation());
            character.get().setPerception(characterDTO.getPerception());
            character.get().setCaution(characterDTO.getCaution());
            character.get().setConjuration(characterDTO.getConjuration());
            characterRepository.save(character.get());
            return character.get();
        }
    }

    public void deleteCharacter(Long id) {
        Optional<Character> character = characterRepository.findById(id);

        if(character.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character with id " +id+ " not found");
        }{
            characterRepository.delete(character.get());
        }
    }
}
