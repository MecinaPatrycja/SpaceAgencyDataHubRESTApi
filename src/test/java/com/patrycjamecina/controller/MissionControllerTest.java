package com.patrycjamecina.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrycjamecina.model.Mission;
import com.patrycjamecina.model.Product;
import com.patrycjamecina.service.impl.MissionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(MockitoJUnitRunner.class)
public class MissionControllerTest {
    @InjectMocks
    private MissionController missionController;
    @Mock
    private MissionServiceImpl missionService;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(missionController).build();
    }

    @Test
    public void add_Mission_Test() throws Exception {
        List<Product> products = new ArrayList<>();
        Date startDate = new Date();
        Date finishDate = new Date();
        Mission mission = new Mission("SpaceExplorer", startDate, finishDate, "PANCHROMATIC", products);
        this.mockMvc.perform(post("/mission/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(mission)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String toJson(Mission mission) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(mission);
    }
}