package com.templates.springapiserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerTests {

    @Autowired MockMvc mockMvc;

    @DisplayName("/api/client-info success")
    @Test
    void apiTestController_api_success() throws Exception {
        mockMvc.perform(get("/api/client-info").header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"clientIP\":\"127.0.0.1\"}"));
    }

    @DisplayName("/api/client-info, 401 error")
    @Test
    void apiTestController_api_fail() throws Exception {
        mockMvc.perform(get("/api/client-info")).andExpect(status().is4xxClientError());
    }
}
