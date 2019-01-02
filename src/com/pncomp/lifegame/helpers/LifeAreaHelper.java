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

    public static int numberOfOrganisms(final LifeField[]  lifeFields, boolean onlyOld){
        int n=0;
        for (int i = 0; i < lifeFields.length; i++) {
            LifeField lifeField = lifeFields[i];
            if(lifeField.getOrg()!=null && ((onlyOld && !lifeField.getOrg().isYoung()) || !onlyOld)){
                n++;
            }
        }
        return n;
    }

}
