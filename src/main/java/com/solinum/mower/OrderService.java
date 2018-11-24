package com.solinum.mower;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderService {
    public static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());
    private String orders;

    public OrderService() {
    }

    public void executeOrder(OrderRequest orderRequest){
        for (int i=0; i<orderRequest.orders.length(); i++){
            if (orderRequest.orders.charAt(i) == 'G' || orderRequest.orders.charAt(i) == 'D'){
                /*
                *   // ToDo
                *   Change direction of the mower
                *
                * */
            } else if (orderRequest.orders.charAt(i) == 'A'){
                /*
                *   // ToDo
                *   Advance the mower
                *
                * */
            }
        }
    }
}
