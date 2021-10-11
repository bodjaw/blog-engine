package com.ilmirbaichurin.blogengine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilmirbaichurin.blogengine.api.response.PostResponse;
import com.ilmirbaichurin.blogengine.api.response.dto.PostsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiPostController.class)
public class ApiPostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApiPostController controller;

    @Autowired
    private ObjectMapper json;

    @Test
    public void emtpyParamsTest() throws Exception {
        PostResponse response = getResponse();
        when(controller.posts(0, 0, "")).thenReturn(ResponseEntity.ok(response));

        this.mvc.perform(get("/api/post")
                .param("offset", "")
                .param("limit", "")
                .param("mode", "recent"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    private PostResponse getResponse() {
        PostResponse response = new PostResponse();
        response.add(new PostsDTO.Builder().id(1).title("Java").build());
        response.add(new PostsDTO.Builder().id(2).title("Spring Framework").build());
        response.add(new PostsDTO.Builder().id(3).title("MySQL").build());
        response.add(new PostsDTO.Builder().id(4).title("Scala").build());
        response.add(new PostsDTO.Builder().id(5).title("Go").build());
        response.add(new PostsDTO.Builder().id(6).title("Python").build());
        response.add(new PostsDTO.Builder().id(7).title("С++").build());
        response.add(new PostsDTO.Builder().id(8).title("Java").build());
        response.add(new PostsDTO.Builder().id(9).title("С#").build());
        response.add(new PostsDTO.Builder().id(10).title("Ruby").build());
        return response;
    }
}