package com.pncomp.lifegame.helpers;

import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;

public class LifeAreaHelper {

    public static int numberOfOrganisms(final LifeArea area) {
        LifeField[][] lifeFields = area.getLifeFields();
        int n = 0;
        for (int i = 0; i < area.getLifeFields().length; i++)
            for (int j = 0; j < area.getLifeFields()[i].length; j++) {
                if (area.getLifeFields()[i][j].getOrg() != null) {
                    n++;
                }
            }
        return n;
    }

}
