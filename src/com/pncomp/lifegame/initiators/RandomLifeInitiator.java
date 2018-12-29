package com.pncomp.lifegame.initiators;

import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.Organism;

import java.util.Random;

public class RandomLifeInitiator implements LifeInitiator {

    private final double percentage;


    public RandomLifeInitiator(double percentage) {
        this.percentage = percentage;
    }


    @Override
    public void initiateLife(LifeArea area) {

        Random r = new Random();
        for(int i=0; i< area.getLifeFields().length; i++)
            for(int j = 0 ; j< area.getLifeFields()[i].length; j++)
                if(r.nextDouble()<percentage/100){
                    Organism org = new Organism();
                    org.setYoung(false);
                    area.getLifeFields()[i][j].setOrg(org);
                }

    }

}
