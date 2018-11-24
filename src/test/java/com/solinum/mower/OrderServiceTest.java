package com.solinum.mower;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderService orderService;

    @Test
    public void executeOrder() {
        //given
        OrderRequest orderRequest =new OrderRequest();
        orderRequest.posAbs = 1;
        orderRequest.posOrd = 2;
        orderRequest.dir = "N";
        orderRequest.orders = "GAGAGAGAA";
        orderRequest.topRight = 5;
        orderRequest.lowerLeft = 5;

        //then
        orderService.executeOrder(orderRequest);

        //when
        verify(orderService, times(1)).executeOrder(orderRequest);
    }
}