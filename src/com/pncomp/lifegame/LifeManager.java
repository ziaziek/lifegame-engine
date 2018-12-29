package com.pncomp.lifegame;

import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.initiators.AreaInitiator;
import com.pncomp.lifegame.initiators.LifeInitiator;
import com.pncomp.lifegame.presenters.AreaPresenter;
import com.pncomp.lifegame.proliferators.Proliferator;

/**
 * This class manages life simulation.
 */
public class LifeManager {

    public LifeArea getArea() {
        return area;
    }

    private LifeArea area;
    private int decreaseFood = -1;
    private  int increaseFood = 1;
    private boolean initRun;

    public AreaPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(AreaPresenter presenter) {
        this.presenter = presenter;
    }

    private AreaPresenter presenter;

    public LifeManager(final LifeArea area){
        this.area=area;
    }

    public  LifeManager(){};

    /**
     * Runs life simulation.
     * @param numberOfEpochs Number of iterations
     * @param proliferator proliferator to simulate organisms proliferation.
     */
    public void run(final int numberOfEpochs, final Proliferator proliferator){

        if(!initRun){
            System.err.println("You may be running the manager without prior initialisation!");
            System.out.println("If this is a subsequent run of this instance, and init was run, you may ignore this message.");
        }

        for(int i=0; i< numberOfEpochs; i++){
            runEpoch(proliferator);
        }

        initRun=false;
    }

    /**
     * Initiate the manager. If area is not defined, this initiates the area and its fields
     * @param initiator
     * @param areaInitiator
     * @throws Exception
     */
    public void init(LifeInitiator initiator, AreaInitiator areaInitiator) throws Exception {
        if(area==null){
            if(areaInitiator==null){
                throw new Exception("For empty area a valid initiator is required!");
            }
            try {
                    area = new LifeArea(new LifeField[10][10]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        areaInitiator.initiateAreaFields(area);
        initiator.initiateLife(area);
        initRun=true;
    }

    protected void runEpoch(final Proliferator proliferator)
    {

        for(int i = 0; i < area.getLifeFields().length; i++){
            for(int j=0; j< area.getLifeFields()[i].length; j++){
                final LifeField field = area.getLifeFields()[i][j];
                //kill organisms where no food
                if(field.getFood()==0){
                    field.setOrg(null);
                }

                    //deduct food if organism
                    if(field.getOrg()!=null && !field.getOrg().isYoung()){
                        field.changeFoodPotential(decreaseFood);
                    }

                //increase food if NO organism
                if(field.getOrg()==null){
                    field.changeFoodPotential(increaseFood);
                }

                //proliferate organisms
                if(proliferator!=null){
                    proliferator.proliferateFromField(field, area.adjacentFields(i,j));
                }

                //age organism
                if(field.getOrg()!=null && field.getOrg().isYoung()){
                    field.getOrg().setYoung(false);
                }
            }
        }
        present(area);

    }

    private int numberOfOrganisms(final LifeArea area) {
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

    protected void present(LifeArea area){
        if(presenter!=null){
            presenter.printArea(area);
        }
    }
}
