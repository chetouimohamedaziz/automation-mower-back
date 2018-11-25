package com.solinum.mower;

import com.solinum.mower.dto.request.GrassRequest;
import com.solinum.mower.dto.request.MowerRequest;
import com.solinum.mower.dto.request.OrderRequest;
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
        MowerRequest mowerRequest = new MowerRequest();
        mowerRequest.posAbs = 1;
        mowerRequest.posOrd = 2;
        mowerRequest.dir = "N";
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.orders = "GAGAGAGAA";
        GrassRequest grassRequest = new GrassRequest();
        grassRequest.topRight = 5;
        grassRequest.lowerLeft = 5;

        //then
        orderService.executeOrder(orderRequest);

        //when
        verify(orderService, times(1)).executeOrder(orderRequest);
    }
}