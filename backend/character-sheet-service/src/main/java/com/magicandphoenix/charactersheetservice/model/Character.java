package com.magicandphoenix.charactersheetservice.model;

import com.magicandphoenix.charactersheetservice.controller.dto.CharacterDTO;
import com.magicandphoenix.charactersheetservice.enums.Country;
import com.magicandphoenix.charactersheetservice.enums.Profession;
import com.magicandphoenix.charactersheetservice.enums.RacialLineage;


import javax.persistence.*;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "character_sheet")
public class Character {

    //Basic info
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long gameId;
    private String name;
    @Enumerated(EnumType.STRING)
    private RacialLineage racialLineage;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Profession profession;

    //Px, can only be giving by the master
    private int px;

    //Attributes
    private int physical;
    private int skill;
    private int mental;
    private int social;


    //The list with the common aptitudes

    private int athletics;
    private int knowledge;
    private int interpretation;
    private int perception;
    private int caution;
    private int conjuration;

    //================================================
    //Constructors
    //================================================

    public Character() {
    }

    public Character(CharacterDTO characterDTO) {


        //basic info
        setName(characterDTO.getName());
        setUserId(characterDTO.getUserId());
        setGameId(characterDTO.getGameId());
        setRacialLineage(RacialLineage.valueOf(characterDTO.getRacialLineage().toUpperCase()));
        setCountry(Country.valueOf(characterDTO.getCountry().toUpperCase()));
        setProfession(Profession.valueOf(characterDTO.getProfession().toUpperCase()));
        setPx(characterDTO.getPx());

        //Attributes
        setPhysical(characterDTO.getPhysical());
        setSkill(characterDTO.getSkill());
        setMental(characterDTO.getMental());
        setSocial(characterDTO.getSocial());

        //Basic skills
        setAthletics(characterDTO.getAthletics());
        setKnowledge(characterDTO.getKnowledge());
        setInterpretation(characterDTO.getInterpretation());
        setPerception(characterDTO.getPerception());
        setCaution(characterDTO.getCaution());
        setConjuration(characterDTO.getConjuration());
    }

    public Character(Long userId,Long gameId, String name, RacialLineage racialLineage, Country country, Profession profession, int px, int physical, int skill, int mental, int social, int athletics, int knowledge, int interpretation, int perception, int caution, int conjuration) {
        //basic info
        setName(name);
        setUserId(userId);
        setGameId(gameId);
        setRacialLineage(racialLineage);
        setCountry(country);
        setProfession(profession);
        setPx(px);

        //Attributes
        setPhysical(physical);
        setSkill(skill);
        setMental(mental);
        setSocial(social);

        //Basic skills
        setAthletics(athletics);
        setKnowledge(knowledge);
        setInterpretation(interpretation);
        setPerception(perception);
        setCaution(caution);
        setConjuration(conjuration);
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RacialLineage getRacialLineage() {
        return racialLineage;
    }

    public void setRacialLineage(RacialLineage racialLineage) {
        this.racialLineage = racialLineage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(int interpretation) {
        this.interpretation = interpretation;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getCaution() {
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }

    public int getConjuration() {
        return conjuration;
    }

    public void setConjuration(int conjuration) {
        this.conjuration = conjuration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}



