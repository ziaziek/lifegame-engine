package com.pncomp;

import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.helpers.LifeManagerFactory;
import com.pncomp.lifegame.initiators.DefaultRandomAreaInitiator;
import com.pncomp.lifegame.initiators.RandomLifeInitiator;
import com.pncomp.lifegame.LifeManager;
import com.pncomp.lifegame.presenters.AreaPresenter;
import com.pncomp.lifegame.presenters.StatisticsPresenter;
import com.pncomp.lifegame.proliferators.SimpleProliferator;

public class Main {

    private static final int AREA_SIZE=40;

    public static void main(String[] args) throws Exception {

        LifeManager mngr = LifeManagerFactory.createLifeManager(AREA_SIZE);
        try {
            mngr.addSimulationListener(new AreaPresenter());
            mngr.addSimulationListener(new StatisticsPresenter());
            mngr.init(new RandomLifeInitiator(20), new DefaultRandomAreaInitiator(3));
            mngr.run(50, new SimpleProliferator());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void permute(int[] numbers, int many){
        for(int i=0; i< numbers.length; i++){
            String p="";
            for(int j = 0; j<numbers.length; j++){
               if(i!=j){
                   p+=numbers[j]+",";
               }
            }
            System.out.println(p);
        }
    }
}
