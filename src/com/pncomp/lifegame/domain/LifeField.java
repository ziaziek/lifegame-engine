package com.pncomp.lifegame.domain;

public class LifeField {

    public int getFood() {
        return food;
    }

    private int food;

    public int getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(int maxFood) {
        if(this.maxFood<=0){
            this.maxFood = maxFood;
        }
    }

    private int maxFood=0;

    public Organism getOrg() {
        return org;
    }

    public void setOrg(Organism org) {
        this.org = org;
    }

    private Organism org;


    /**
     * Changes the food at the field by the amount provided.
     * @param inc If negative, this will decrease the amount of food until it reaches 0. If positive, this will increase the food potential
     *            until the maximum is reached.
     */
    public void changeFoodPotential(int inc){
        if(inc > 0){
            food=Math.min(maxFood, food+inc);
        } else {
            food = Math.max(0, food+inc);
        }
    }

}
