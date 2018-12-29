package com.pncomp.lifegame.proliferators;

import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.domain.Organism;

public class SimpleProliferator implements Proliferator {

    @Override
    public void proliferateFromField(LifeField field, LifeField[] adj) {

        if(field.getOrg()!=null && !field.getOrg().isYoung()){
            for(LifeField lf : adj){
                if(lf.getOrg()==null && lf.getFood()>0 ){
                    lf.setOrg(new Organism());
                    break;
                }
            }
        }

    }
}
