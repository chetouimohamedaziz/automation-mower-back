package com.solinum.mower.dto;

public class Grass {
    private int topRight;
    private int lowerLeft;

    public Grass(int topRight, int lowerLeft) {
        this.topRight = topRight;
        this.lowerLeft = lowerLeft;
    }

    public int getTopRight() {
        return topRight;
    }

    public void setTopRight(int topRight) {
        this.topRight = topRight;
    }

    public int getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(int lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    @Override
    public String toString() {
        return "Grass{" +
                "topRight=" + topRight +
                ", lowerLeft=" + lowerLeft +
                '}';
    }
}
