package com.solinum.mower.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mower extends Coordinate {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Enum<Direction> initDirection;

    public Mower(int abs, int ord, Enum<Direction> initDirection) {
        super(abs, ord);
        this.initDirection = initDirection;
    }

    public Enum<Direction> getInitDirection() {
        return initDirection;
    }

    public void setInitDirection(Enum<Direction> initDirection) {
        this.initDirection = initDirection;
    }

    @Override
    public String toString() {
        return "Mower{" +
                super.toString() +
                ", initDirection=" + initDirection +
                '}';
    }

    public void changeDirection(char direction){
        if (direction == 'D'){
            switch (this.getInitDirection().toString()) {
                case "N":
                    this.setInitDirection(Direction.E);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "E":
                    this.setInitDirection(Direction.S);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "S":
                    this.setInitDirection(Direction.W);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "W":
                    this.setInitDirection(Direction.N);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
            }
        } else if (direction == 'G'){
            switch (this.getInitDirection().toString()){
                case "N":
                    this.setInitDirection(Direction.W);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "W":
                    this.setInitDirection(Direction.S);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "S":
                    this.setInitDirection(Direction.E);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
                case "E":
                    this.setInitDirection(Direction.N);
                    logger.info("Newest initDirection=" + this.initDirection);
                    break;
            }
        }
    }

    public void nextStep(int topRight, int lowerLeft){
        switch (this.getInitDirection().toString()){
            case "N":
                if (this.getOrd()>=0){
                    this.setOrd(this.getOrd()+1);
                }
                logger.info(this.toString());
                break;
            case "S":
                if (this.getOrd()<lowerLeft){
                    this.setOrd(this.getOrd()-1);
                }
                logger.info(this.toString());
                break;
            case "W":
                if (this.getAbs()>=0){
                    this.setAbs(this.getAbs()-1);
                }
                logger.info(this.toString());
                break;
            case "E":
                if (this.getAbs()<topRight){
                    this.setAbs(this.getAbs()+1);
                }
                logger.info(this.toString());
                break;
        }
    }
}
