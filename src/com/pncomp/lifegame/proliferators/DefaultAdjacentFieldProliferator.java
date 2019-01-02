package com.pncomp.lifegame.proliferators;

import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.domain.Organism;

public class DefaultAdjacentFieldProliferator implements Proliferator {

    @Override
    public void proliferateFromField(LifeField field, LifeField[] adj) {

        if(canProliferate(field)){
            populateAdjacentFields(adj);
        }

    }

    protected void populateAdjacentFields(LifeField[] adj) {
        for(LifeField lf : adj){
            if(canBePopulated(lf)){
                lf.setOrg(new Organism());
                break;
            }
        }
    }

    protected boolean canProliferate(final LifeField field) {

        return field.getOrg() != null && !field.getOrg().isYoung();

    }

    protected boolean canBePopulated(final LifeField field){
        return field.getOrg()==null &&  field.getFood()>0;
    }

}
