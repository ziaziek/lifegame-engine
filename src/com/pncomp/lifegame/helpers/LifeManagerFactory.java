package com.pncomp.lifegame.helpers;

import com.pncomp.lifegame.LifeManager;
import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.initiators.AreaInitiator;
import com.pncomp.lifegame.initiators.DefaultRandomAreaInitiator;
import com.pncomp.lifegame.initiators.LifeInitiator;
import com.pncomp.lifegame.initiators.RandomLifeInitiator;

public class LifeManagerFactory {

    /**
     * Created a life manager with random life initiator and 50% chance of organism, Default Area Initiator with max food equal 5
     * @return
     */
    public static LifeManager createLifeManager() throws Exception {
        return createLifeManager(50, 5);
    }

    /**
     * Creates life manager with Random Life Initiator and Default Area Initiator
     * @param lifePercentage chance of organism set up
     * @param maxFood maximu food for life fields.
     * @return
     * @throws Exception
     */
    public static LifeManager createLifeManager(final int lifePercentage, final int maxFood) throws Exception {
        LifeManager mngr = new LifeManager();
        mngr.init(new RandomLifeInitiator(lifePercentage), new DefaultRandomAreaInitiator(maxFood));
        return mngr;
    }

    /**
     * Creates life manager
     * @param initiator life initiator
     * @param areaInitiator area initiator
     * @return
     * @throws Exception
     */
    public static LifeManager createLifeManager(final LifeInitiator initiator, final AreaInitiator areaInitiator) throws Exception {
        LifeManager mngr = new LifeManager();
        mngr.init(initiator, areaInitiator);
        return mngr;
    }

    /**
     * Creates life manager of a given area size
     * @param areaSize
     * @return
     * @throws Exception
     */
    public static LifeManager createLifeManager(final int areaSize) throws Exception {
        return createLifeManager(areaSize, 50, 5);
    }

    /**
     * Create life manager of a given area size, life percentage and maxFood
     * @param areaSize
     * @param lifePercentage
     * @param maxFood
     * @return
     * @throws Exception
     */
    public static LifeManager createLifeManager(final int areaSize, final int lifePercentage, final int maxFood) throws Exception {
        LifeArea area = new LifeArea(new LifeField[areaSize][areaSize]);
        LifeManager mngr = new LifeManager(area);
        mngr.init(new RandomLifeInitiator(lifePercentage), new DefaultRandomAreaInitiator(maxFood));
        return mngr;
    }
}
