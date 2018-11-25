package com.solinum.mower.dto;

public class Coordinate {
    private int abs;
    private int ord;

    public Coordinate(int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "abs=" + abs +
                ", ord=" + ord +
                '}';
    }
}
