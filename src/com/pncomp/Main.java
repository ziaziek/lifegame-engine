package com.pncomp;

import com.pncomp.lifegame.helpers.LifeManagerFactory;
import com.pncomp.lifegame.LifeManager;
import com.pncomp.lifegame.presenters.AreaPresenter;
import com.pncomp.lifegame.presenters.StatisticsPresenter;
import com.pncomp.lifegame.proliferators.PairProliferator;

public class Main {

    private static final int AREA_SIZE = 6;

    public static void main(String[] args) throws Exception {

        LifeManager mngr = LifeManagerFactory.createLifeManager(AREA_SIZE, 15, 30);
        try {
            mngr.addSimulationListener(new AreaPresenter());
            mngr.addSimulationListener(new StatisticsPresenter());
            mngr.run(5, new PairProliferator());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void permute(int[] numbers, int many) {
        for (int i = 0; i < numbers.length; i++) {
            String p = "";
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    p += numbers[j] + ",";
                }
            }
            System.out.println(p);
        }
    }
}
