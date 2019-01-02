package com.pncomp.lifegame.domain;

public class Organism {

    public Organism(){

    }

    public Organism(boolean young) {
        this.young=young;
    }

    public boolean isYoung() {
        return young;
    }

    public void setYoung(boolean young) {
        this.young = young;
    }

    private boolean young=true;

}
