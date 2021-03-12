package com.magicandphoenix.gameservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magicandphoenix.gameservice.controller.dto.UserDTO;
import com.magicandphoenix.gameservice.model.Game;
import com.magicandphoenix.gameservice.model.UserId;
import com.magicandphoenix.gameservice.repository.GameRepository;
import com.magicandphoenix.gameservice.repository.UserIdRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class GameControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserIdRepository userIdRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        UserId AntonioId = new UserId(1L);
        UserId RomuId = new UserId(2L);
        UserId VillaId = new UserId(3L);
        UserId ElifId = new UserId(4L);
        userIdRepository.saveAll(List.of(AntonioId, RomuId, VillaId, ElifId));

        //The name of the master 1 is Nacho
        Game tartKrossGame = new Game("Partida de TartKross", 1L);
        List<UserId> tartKrossUserList = new ArrayList<>();
        tartKrossUserList.add(AntonioId);
        tartKrossUserList.add(RomuId);
        tartKrossUserList.add(VillaId);
        tartKrossGame.setUserIdList(tartKrossUserList);

        //The name of the master 1 is Nacho
        Game taroKorosuGame = new Game("Partida de Taro Korosu", 1L);

        //The name of the master 1 is Villa
        Game samirGame = new Game("Partida de Samir", 2L);
        List<UserId> samirUserList = new ArrayList<>();
        samirUserList.add(AntonioId);
        samirUserList.add(ElifId);
        samirUserList.add(VillaId);
        samirGame.setUserIdList(samirUserList);

        gameRepository.saveAll(List.of(tartKrossGame, taroKorosuGame, samirGame));

    }

    @AfterEach
    void tearDown() {
        gameRepository.deleteAll();
        userIdRepository.deleteAll();
    }

    @Test
    void gameList() throws Exception {
        MvcResult result = mockMvc.perform(get("/games"))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Partida de Taro Korosu"));
    }

    @Test
    void getGameListByName() throws Exception {
        String name = "Partida de Samir";
        MvcResult result = mockMvc.perform(get("/games/name/"+name))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("2"));
        assertFalse(result.getResponse().getContentAsString().contains("1"));

        String name2= "Partida de TartKross";
        MvcResult result2 = mockMvc.perform(get("/games/name/"+name2))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result2.getResponse().getContentAsString().contains("1"));
        assertFalse(result2.getResponse().getContentAsString().contains("2"));

    }

    @Test
    void getGameListByUserId() throws Exception {
        long romuId = 2L;
        MvcResult result = mockMvc.perform(get("/games/user-id/"+romuId))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Partida de TartKross"));
        assertFalse(result.getResponse().getContentAsString().contains("Partida de Samir"));

        long elifId = 4L;
        MvcResult result2 = mockMvc.perform(get("/games/user-id/"+elifId))
                            .andExpect(status().isOk()).andReturn();
        assertFalse(result2.getResponse().getContentAsString().contains("Partida de TartKross"));
        assertTrue(result2.getResponse().getContentAsString().contains("Partida de Samir"));

    }

    @Test
    void getGameListByMasterId() throws Exception {
        long nachoId = 1L;
        MvcResult result = mockMvc.perform(get("/games/master-id/"+nachoId))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Partida de TartKross"));
        assertFalse(result.getResponse().getContentAsString().contains("Partida de Samir"));

        long villaId = 2L;
        MvcResult result2 = mockMvc.perform(get("/games/master-id/"+villaId))
                .andExpect(status().isOk()).andReturn();
        assertFalse(result2.getResponse().getContentAsString().contains("Partida de TartKross"));
        assertTrue(result2.getResponse().getContentAsString().contains("Partida de Samir"));

    }

    @Test
    void getGameById() throws Exception {
        List<Game> gameList = gameRepository.findAll();
        Long tartKrossGameId = gameList.get(0).getId();

        MvcResult result = mockMvc.perform(get("/game/"+tartKrossGameId))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Partida de TartKross"));
        assertFalse(result.getResponse().getContentAsString().contains("Partida de Samir"));
    }

    @Test
    void createGame() throws Exception {
        Game game = new Game("Partida de la leyenda de los 5 anillos", 3L);
        String body = objectMapper.writeValueAsString(game);
        MvcResult result = mockMvc.perform(post("/game")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Partida de la leyenda de los 5 anillos"));
        assertEquals(4, gameRepository.findAll().size());
    }

    @Test
    void addNewPlayer() throws Exception {
        List<Game> gameList = gameRepository.findAll();
        Long gameId = gameList.get(0).getId();
        UserDTO userId = new UserDTO(987L);
        String body = objectMapper.writeValueAsString(userId);
        MvcResult result = mockMvc.perform(patch("/game/"+gameId+"/add-player")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("987"));
        assertEquals(4, gameRepository.findById(gameId).get().getUserIdList().size());
    }

    @Test
    void deleteGame() throws Exception {
        List<Game> gameList = gameRepository.findAll();
        Long gameId = gameList.get(0).getId();

        MvcResult result = mockMvc.perform(delete("/game/"+gameId))
                .andExpect(status().isNoContent()).andReturn();

        assertFalse(result.getResponse().getContentAsString().contains("TartKross"));
        assertEquals(2, gameRepository.findAll().size());
    }
}