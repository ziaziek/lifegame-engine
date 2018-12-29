package com.pncomp.lifegame.presenters;

import com.pncomp.lifegame.domain.LifeArea;

/**
 * This class defines how the life area is presented to the user.
 * This particular implementation prints out the area to the console.
 * To change this behaviour, override @printArea method
 */
public class AreaPresenter {

    /**
     * Prints out or presents the are to the user.
     * @param area Area to present.
     */
    public void printArea(final LifeArea area ){
        for (int i = 0; i < area.getLifeFields().length; i++) {
            for (int j = 0; j < area.getLifeFields()[i].length; j++) {
                System.out.print(area.getLifeFields()[i][j].getOrg() != null ? " 1 " : " 0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

//    public void printAreaWithFood(final LifeArea area){
//        for (int i = 0; i < area.getLifeFields().length; i++) {
//            for (int j = 0; j < area.getLifeFields()[i].length; j++) {
//                System.out.print(" ["+ (area.getLifeFields()[i][j].getOrg() != null ? " 1 " : " 0 ") +"-"+ String.valueOf(area.getLifeFields()[i][j].getFood())+"] ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
