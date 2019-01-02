import com.pncomp.lifegame.LifeManager;
import com.pncomp.lifegame.domain.LifeArea;
import com.pncomp.lifegame.domain.LifeField;
import com.pncomp.lifegame.domain.Organism;
import com.pncomp.lifegame.helpers.LifeAreaHelper;
import com.pncomp.lifegame.initiators.DefaultRandomAreaInitiator;
import com.pncomp.lifegame.initiators.RandomLifeInitiator;
import com.pncomp.lifegame.proliferators.PairProliferator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairProliferatorTests {

    @Test
    public void pairTests() throws Exception {
        LifeArea area = new LifeArea(new LifeField[5][5]);
        LifeManager mngr = new LifeManager(area);
        mngr.init(new RandomLifeInitiator(0), new DefaultRandomAreaInitiator(400));
        area.getLifeFields()[0][0].setOrg(new Organism(false));
        area.getLifeFields()[0][1].setOrg(new Organism(false));
        Assertions.assertEquals(2, LifeAreaHelper.numberOfOrganisms(area));
        mngr.run(1, new PairProliferator());
        Assertions.assertEquals(4, LifeAreaHelper.numberOfOrganisms(area));
        area.clear();
        Assertions.assertTrue(LifeAreaHelper.numberOfOrganisms(area)==0);
        area.getLifeFields()[3][1].setOrg(new Organism(false));
        area.getLifeFields()[3][2].setOrg(new Organism(false));
        Assertions.assertEquals(2, LifeAreaHelper.numberOfOrganisms(area));
        mngr.run(1, new PairProliferator());
        Assertions.assertEquals(4, LifeAreaHelper.numberOfOrganisms(area));
        area.clear();
        area.getLifeFields()[3][1].setOrg(new Organism(false));
        area.getLifeFields()[3][2].setOrg(new Organism(false));
        area.getLifeFields()[3][3].setOrg(new Organism(false));
        area.getLifeFields()[3][4].setOrg(new Organism(true));
        Assertions.assertEquals(4, LifeAreaHelper.numberOfOrganisms(area));
        mngr.run(1, new PairProliferator());
        Assertions.assertEquals(7, LifeAreaHelper.numberOfOrganisms(area));
    }
}
