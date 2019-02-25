package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DemoController.class)
class DemoControllerTest {
    private static final String PAYLOAD_IN_GET = "{\"payloadInGet\":true}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPayload() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/demo")
                        .contentType("application/json")
                        .content(PAYLOAD_IN_GET))
                .andExpect(status().isOk())
                .andReturn();

        String actualPayload = mvcResult.getResponse().getContentAsString();

        assertThat(actualPayload)
                .isEqualTo(PAYLOAD_IN_GET);
    }
}