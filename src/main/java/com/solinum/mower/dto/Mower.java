package com.solinum.mower.dto;

public class Mower extends Coordinate {
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
                "initDirection=" + initDirection +
                '}';
    }
}
