package com.ilmirbaichurin.blogengine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilmirbaichurin.blogengine.api.response.InitResponse;
import com.ilmirbaichurin.blogengine.api.response.SettingsResponse;
import com.ilmirbaichurin.blogengine.api.response.TagResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiGeneralController.class)
public class ApiGeneralControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApiGeneralController controller;

    @Autowired
    private ObjectMapper json;

    @Test
    public void GET_ApiInitTest() throws Exception {
        InitResponse response = new InitResponse();
        response.setTitle("HowCode");
        response.setSubtitle("Рассказы разработчиков");
        response.setPhone("+7 903 666-44-55");
        response.setEmail("mail@mail.ru");
        response.setCopyright("Ильмир Байчурин");
        response.setCopyrightFrom("2020");

        given(controller.init()).willReturn(ResponseEntity.ok(response));
        this.mvc.perform(get("/api/init"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json.writeValueAsString(response)));
    }


    @Test
    public void GET_ApiSettingsTest() throws Exception {
        SettingsResponse settings = new SettingsResponse(true, true, false);
        given(controller.settings()).willReturn(ResponseEntity.ok(settings));
        this.mvc.perform(get("/api/settings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json.writeValueAsString(settings)));
    }

    @Test
    public void GET_ApiTagsWhenEmptyQueryTest() throws Exception {
        TagResponse tags = new TagResponse();
        tags.add("Java", 0.9);
        tags.add("Python", 0.8);
        tags.add("JavaStart", 0.6);
        tags.add("HTML", 0.1);

        given(controller.tag("")).willReturn(ResponseEntity.ok(tags));
        mvc.perform(get("/api/tag").param("query", ""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json.writeValueAsString(tags)));
    }

    @Test
    public void GET_ApiTagsByGivenQueryTest() throws Exception {
        TagResponse tags = new TagResponse();
        tags.add("Java", 0.9);
        tags.add("JavaStart", 0.6);

        given(controller.tag("Java")).willReturn(ResponseEntity.ok(tags));
        mvc.perform(get("/api/tag").param("query", "Java"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(json.writeValueAsString(tags)));
    }
}