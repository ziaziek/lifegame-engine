package com.pncomp.lifegame.initiators;

import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;

import java.util.Random;

public class DefaultRandomAreaInitiator implements AreaInitiator {

    private final int maxFood;

    public DefaultRandomAreaInitiator(final int maxFood){
        this.maxFood=maxFood;
    }

    @Override
    public void initiateAreaFields(LifeArea area) {
        Random r = new Random();
        for (int i=0; i< area.getLifeFields().length; i++)
            for (int j=0; j< area.getLifeFields()[i].length; j++){
                if(area.getLifeFields()[i][j]==null){
                    area.getLifeFields()[i][j]=new LifeField();
                }
                LifeField field = area.getLifeFields()[i][j];
                field.setMaxFood(r.nextInt(maxFood));
                field.changeFoodPotential(r.nextInt(maxFood));
            }
    }
}
