package com.magicandphoenix.charactersheetservice.controller.dto;

import com.magicandphoenix.charactersheetservice.enums.Country;
import com.magicandphoenix.charactersheetservice.enums.Profession;
import com.magicandphoenix.charactersheetservice.enums.RacialLineage;
import com.magicandphoenix.charactersheetservice.model.Character;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CharacterDTO {


    @NotEmpty
    private String name;

    @NotEmpty
    private Long userId;

    @NotEmpty
    private String racialLineage;

    @NotEmpty
    private String country;

    @NotEmpty
    private String profession;

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

    public CharacterDTO() {
    }

    public CharacterDTO(Character character){
        //basic info
        setName(character.getName());
        setUserId(character.getUserId());
        setRacialLineage(character.getRacialLineage().toString());
        setCountry(character.getCountry().toString());
        setProfession(character.getProfession().toString());
        setPx(character.getPx());

        //Attributes
        setPhysical(character.getPhysical());
        setSkill(character.getSkill());
        setMental(character.getMental());
        setSocial(character.getSocial());

        //Basic skills
        setAthletics(character.getAthletics());
        setKnowledge(character.getKnowledge());
        setInterpretation(character.getInterpretation());
        setPerception(character.getPerception());
        setCaution(character.getCaution());
        setConjuration(character.getConjuration());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRacialLineage() {
        return racialLineage;
    }

    public void setRacialLineage(String racialLineage) {
        this.racialLineage = racialLineage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
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
