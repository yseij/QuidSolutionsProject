package com.example.quidsolutionsproject.UnitTest;

import com.example.quidsolutionsproject.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MainControllerUnitTest {

    @Autowired
    private MainController mainController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void testHtmlIndex() throws Exception{
        this.mockMvc.perform(get("/questions"))
                .andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void testHtmlRightAnswer() throws Exception{
        this.mockMvc.perform(post("/checkanswer")).andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8"))).andExpect(status().isOk());
    }
}
