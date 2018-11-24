package com.solinum.mower;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    OrderService orderService;

    @Test
    public void order() throws Exception {
        //given
        OrderRequest orderRequest =new OrderRequest();
        orderRequest.posAbs = 1;
        orderRequest.posOrd = 2;
        orderRequest.dir = "N";
        orderRequest.orders = "GAGAGAGAA";
        orderRequest.topRight = 5;
        orderRequest.lowerLeft = 5;

        //when
        ResultActions resultActions = mockMvc.perform(
                post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderRequest))
        );

        //then
        resultActions.andExpect(status().isOk());
    }
}