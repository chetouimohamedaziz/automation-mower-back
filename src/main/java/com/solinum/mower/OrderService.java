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

    public Enum<Direction> changeDirection(char direction, Enum<Direction> initDirection){
        if (direction == 'D'){
            switch (initDirection.toString()) {
                case "N":
                    initDirection = Direction.E;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "E":
                    initDirection = Direction.S;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "S":
                    initDirection = Direction.W;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "W":
                    initDirection = Direction.N;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
            }
        } else if (direction == 'G'){
            switch (initDirection.toString()){
                case "N":
                    initDirection = Direction.W;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "W":
                    initDirection = Direction.S;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "S":
                    initDirection = Direction.E;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
                case "E":
                    initDirection = Direction.N;
                    logger.info("Newest initDirection=" + initDirection);
                    break;
            }
        }
        return initDirection;
    }

    public Mower nextStep(int topRight, int lowerLeft, Mower mower){
        switch (mower.getInitDirection().toString()){
            case "N":
                if (mower.getOrd()>=0){
                    mower.setOrd(mower.getOrd()+1);
                }
                logger.info(mower.toString());
                break;
            case "S":
                if (mower.getOrd()<lowerLeft){
                    mower.setOrd(mower.getOrd()-1);
                }
                logger.info(mower.toString());
                break;
            case "W":
                if (mower.getAbs()>=0){
                    mower.setAbs(mower.getAbs()-1);
                }
                logger.info(mower.toString());
                break;
            case "E":
                if (mower.getAbs()<topRight){
                    mower.setAbs(mower.getAbs()+1);
                }
                logger.info(mower.toString());
                break;
        }
        return mower;
    }

    public Mower executeOrder(OrderRequest orderRequest){
        mower = new Mower(orderRequest.mower.posAbs, orderRequest.mower.posOrd, Direction.valueOf(orderRequest.mower.dir));
        this.orders = orderRequest.orders;
        grass = new Grass(orderRequest.grass.topRight, orderRequest.grass.lowerLeft);
        logger.info(this.toString());
        for (int i=0; i<this.orders.length(); i++){
            if (this.orders.charAt(i) == 'G' || this.orders.charAt(i) == 'D'){
                // Change Direction of th mower
                mower.setInitDirection(changeDirection(this.orders.charAt(i), mower.getInitDirection()));
            } else if (orderRequest.orders.charAt(i) == 'A'){
                // Advance the mower
                mower = nextStep(grass.getTopRight(), grass.getLowerLeft(), mower);
            }
        }
        return mower;
    }
}
