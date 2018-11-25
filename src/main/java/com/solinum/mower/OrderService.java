package com.solinum.mower;

import com.solinum.mower.dto.Direction;
import com.solinum.mower.dto.Mower;
import com.solinum.mower.dto.request.OrderRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String orders;
    private Mower mower;

    public OrderService() {
    }

    public Mower executeOrder(OrderRequest orderRequest){
        mower = new Mower(orderRequest.mower.posAbs, orderRequest.mower.posOrd, Direction.valueOf(orderRequest.mower.dir));
        logger.info(mower.toString());
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
        return mower;
    }
}
