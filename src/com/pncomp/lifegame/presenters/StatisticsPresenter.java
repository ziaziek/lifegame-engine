package com.pncomp.lifegame.presenters;

import com.pncomp.lifegame.ISimulationListener;
import com.pncomp.lifegame.SimulationEvent;
import com.pncomp.lifegame.SimulationEventType;
import com.pncomp.lifegame.helpers.LifeAreaHelper;

import java.util.ArrayList;
import java.util.List;

public class StatisticsPresenter implements ISimulationListener {

    public List<Integer> getnOrgHostory() {
        return nOrgHostory;
    }

    private List<Integer> nOrgHostory;

    @Override
    public void simulationChanged(SimulationEvent event) {
        if(SimulationEventType.START.equals(event.getType())){
            nOrgHostory=new ArrayList<>();
        }

        if(SimulationEventType.FINISHED.equals(event.getType())){
            printOutHistory();
        } else {
            nOrgHostory.add(LifeAreaHelper.numberOfOrganisms(event.getArea()));
        }
    }

    protected void printOutHistory() {
        for(Integer n: nOrgHostory){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
