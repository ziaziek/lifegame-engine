package com.pncomp.lifegame.presenters;

import com.pncomp.lifegame.ISimulationListener;
import com.pncomp.lifegame.SimulationEvent;
import com.pncomp.lifegame.SimulationEventType;
import com.pncomp.lifegame.domain.LifeArea;

/**
 * This class defines how the life area is presented to the user.
 * This particular implementation prints out the area to the console.
 * To change this behaviour, override @printArea method
 */
public class AreaPresenter implements ISimulationListener {

    /**
     * Prints out or presents the are to the user.
     * @param area Area to present.
     */
    protected void printArea(final LifeArea area ){
        for (int i = 0; i < area.getLifeFields().length; i++) {
            for (int j = 0; j < area.getLifeFields()[i].length; j++) {
                System.out.print(area.getLifeFields()[i][j].getOrg() != null ? " 1 " : " 0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void simulationChanged(SimulationEvent event) {
        if(SimulationEventType.START.equals(event.getType()) || SimulationEventType.EPOCH_RUN.equals(event.getType())){
            printArea(event.getArea());
        }
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
