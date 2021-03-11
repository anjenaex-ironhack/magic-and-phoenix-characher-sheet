package com.magicandphoenix.charactersheetservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magicandphoenix.charactersheetservice.controller.dto.PxDTO;
import com.magicandphoenix.charactersheetservice.enums.Country;
import com.magicandphoenix.charactersheetservice.enums.Profession;
import com.magicandphoenix.charactersheetservice.enums.RacialLineage;
import com.magicandphoenix.charactersheetservice.repository.CharacterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.magicandphoenix.charactersheetservice.model.Character;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private CharacterRepository characterRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Character samirAlKhamid = new Character(1L, 1L, "Samir Al-Khamid", RacialLineage.UNARII, Country.SURKAYA, Profession.NOBLE, 45,
                7,7,7,8,5,2,3,3,2,2);
        Character franciscoAbascal = new Character(2L,1L,"Francisco Abascal", RacialLineage.UNARII, Country.ISPANSAR, Profession.SOLDIER, 5,
                9,10,6,5,5,0,0,1,0,0);

        characterRepository.saveAll(List.of(samirAlKhamid, franciscoAbascal));
    }


    @AfterEach
    void tearDown() {
        characterRepository.deleteAll();
    }

    @Test
    void getCharacterById() throws Exception {

        List<Character> characterList = characterRepository.findAll();

        Long samirId = characterList.get(0).getId();
        MvcResult result = mockMvc.perform(get("/character-sheet/"+samirId))
                          .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Samir Al-Khamid"));
        assertFalse(result.getResponse().getContentAsString().contains("Francisco Abascal"));

        Long SantiagoId = characterList.get(1).getId();
        MvcResult result2 = mockMvc.perform(get("/character-sheet/"+SantiagoId))
                .andExpect(status().isOk()).andReturn();

        assertTrue(result2.getResponse().getContentAsString().contains("Francisco Abascal"));
        assertFalse(result2.getResponse().getContentAsString().contains("Samir Al-Khamid"));
    }

    @Test
    void createCharacter() throws Exception {
        Character TartKross = new Character(1L,1L,  "TartKross", RacialLineage.LORANÄE, Country.BRITEN, Profession.DOCTOR, 450,
                7,7,10,8,5,5,4,3,3,0);

        String body = objectMapper.writeValueAsString((TartKross));
        MvcResult result = mockMvc.perform(
                post("/character-sheet")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("TartKross"));
    }

    @Test
    void upgradeCharacterById() throws Exception {
        List<Character> characterList = characterRepository.findAll();
        Long samirId = characterList.get(0).getId();
        Character nuevoSamir = new Character(1L,1L, "Nuevo Samir Al-Khamid", RacialLineage.LORANÄE, Country.BRITEN, Profession.DOCTOR, 450,
                7,7,10,8,5,5,4,3,3,0);

        String body = objectMapper.writeValueAsString(nuevoSamir);

        mockMvc.perform(
                put("/character-sheet/"+samirId)
                    .content(body)
                    .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isAccepted()).andReturn();

        assertEquals("Nuevo Samir Al-Khamid", characterRepository.findById(samirId).get().getName());

    }

    @Test
    void updatePxById() throws Exception {
        List<Character> characterList = characterRepository.findAll();
        Long samirId = characterList.get(0).getId();
        PxDTO newPx = new PxDTO(88);
        String body = objectMapper.writeValueAsString(newPx);
        MvcResult result = mockMvc.perform(
                patch("/character-sheet/px/"+samirId)
                    .content(body)
                    .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isAccepted()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("88"));
        assertEquals(88, characterRepository.findById(samirId).get().getPx());
    }

    @Test
    void deleteCharacter() throws Exception {
        List<Character> characterList = characterRepository.findAll();
        Long samirId = characterList.get(0).getId();
        //Show that a character with an specific id exist
        assertEquals("Samir Al-Khamid", characterRepository.findById(samirId).get().getName());
        MvcResult result = mockMvc.perform(
                delete("/character-sheet/" + samirId))
                .andExpect(status().isNoContent()).andReturn();
        assertEquals(1, characterRepository.findAll().size());

    }
}