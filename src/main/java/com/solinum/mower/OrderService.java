package com.solinum.mower;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderService {
    public static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());
    private String orders;

    public OrderService(String orders) {
        this.orders = orders;
    }

    public void executeOrder(OrderRequest orderRequest){

    }
}
