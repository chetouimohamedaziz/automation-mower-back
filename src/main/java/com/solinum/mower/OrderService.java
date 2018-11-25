package com.solinum.mower;

import com.solinum.mower.dto.Direction;
import com.solinum.mower.dto.Grass;
import com.solinum.mower.dto.Mower;
import com.solinum.mower.dto.request.OrderRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Mower mower;
    private String orders;
    private Grass grass;

    public OrderService() {
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "mower=" + mower +
                ", orders='" + orders + '\'' +
                ", grass=" + grass +
                '}';
    }

    public void setOrder(OrderRequest orderRequest){
        mower = new Mower(orderRequest.mower.posAbs, orderRequest.mower.posOrd, Direction.valueOf(orderRequest.mower.dir));
        this.orders = orderRequest.orders;
        grass = new Grass(orderRequest.grass.topRight, orderRequest.grass.lowerLeft);
    }

    public Mower executeOrder(OrderRequest orderRequest){
        setOrder(orderRequest);
        logger.info(this.toString());
        for (int i=0; i<this.orders.length(); i++){
            if (this.orders.charAt(i) == 'G' || this.orders.charAt(i) == 'D'){
                // Change Direction of th mower
                mower.changeDirection(this.orders.charAt(i));
            } else if (orderRequest.orders.charAt(i) == 'A'){
                // Advance the mower
                mower.nextStep(grass.getTopRight(), grass.getLowerLeft());
            }
        }
        return mower;
    }
}
