package com.pncomp.lifegame;

public class Pair {
    int x, y;

    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }


    @Override
    public String toString() {
        return "x="+x + ", y="+y;
    }
}
