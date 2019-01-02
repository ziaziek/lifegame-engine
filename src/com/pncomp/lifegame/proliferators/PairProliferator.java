package com.pncomp.lifegame.proliferators;

import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.helpers.LifeAreaHelper;

/**
 * This proliferator class allows organisms to proliferate only if there are two parents (not young) next to each other in the current epoch.
 */
public class PairProliferator extends  DefaultAdjacentFieldProliferator {

    int n_adj_organisms=0;

    @Override
    public void proliferateFromField(LifeField field, LifeField[] adjecents) {

        n_adj_organisms=LifeAreaHelper.numberOfOrganisms(adjecents, true);

        super.proliferateFromField(field, adjecents);

    }

    @Override
    protected boolean canProliferate(LifeField field) {
        return super.canProliferate(field) &&  n_adj_organisms> 0;
    }
}
