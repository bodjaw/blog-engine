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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "/application-test.properties")
public class TagsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApiGeneralController controller;

    @Test
    public void emtpyTagsQueryTest() throws Exception {
        this.mockMvc.perform(get("/api/tag").param("query", ""))
                .andExpect(status().isOk())
                .andExpect(content().json("{'tags':[" +
                        "{'name':'Java','weight':1.0}," +
                        "{'name':'Spring','weight':0.6}," +
                        "{'name':'Hibernate','weight':0.2}," +
                        "{'name':'JavaStart','weight':0.4}]}"));
    }

    @Test
    public void tagsTest() throws Exception {
        this.mockMvc.perform(get("/api/tag").param("query", "Java"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'tags':[" +
                        "{'name':'Java','weight':1.0}," +
                        "{'name':'JavaStart','weight':0.4}]}"));
    }
}
