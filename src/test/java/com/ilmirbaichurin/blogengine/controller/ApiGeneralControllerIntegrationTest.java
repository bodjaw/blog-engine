package com.ilmirbaichurin.blogengine.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "/application-test.properties")
public class ApiGeneralControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApiGeneralController controller;

    @Test
    public void initTest() throws Exception {
        String expectedTitle = "HowCode";
        String expectedSubtitle = "Рассказы разработчиков";
        String expectedPhone = "+7 903 666-44-55";
        String expectedEmail = "mail@mail.ru";
        String expectedCopyright = "Ильмир Байчурин";
        String expectedCopyrightFrom = "2020";

        this.mockMvc.perform(get("/api/init"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(expectedTitle))
                .andExpect(jsonPath("$.subtitle").value(expectedSubtitle))
                .andExpect(jsonPath("$.phone").value(expectedPhone))
                .andExpect(jsonPath("$.email").value(expectedEmail))
                .andExpect(jsonPath("$.copyright").value(expectedCopyright))
                .andExpect(jsonPath("$.copyrightFrom").value(expectedCopyrightFrom));
    }

    @Test
    @Sql(value = {"/sql/global_settings_test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/drop_settings.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void settingsTest() throws Exception {
        this.mockMvc.perform(get("/api/settings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.MULTIUSER_MODE").value(false))
                .andExpect(jsonPath("$.POST_PREMODERATION").value(true))
                .andExpect(jsonPath("$.STATISTICS_IS_PUBLIC").value(false));
    }
}