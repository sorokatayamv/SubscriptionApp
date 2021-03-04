package subscription.services;

import org.testng.Assert;
import org.testng.annotations.Test;
import subscription.model.Edition;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class EditionServiceImplTest {
    EditionService editionService = new EditionServiceImpl();

    @Test
    public void testGetEditionById() {
        int idActual = 1;
        String nameActual = "Vogue";
        float costActual = 350;

        Edition editionExpected = editionService.get(1);
        int idExpected = editionExpected.getId();
        String nameExpected = editionExpected.getName();
        float costExpected = editionExpected.getCost();

        Assert.assertEquals(idExpected, idActual);
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertEquals(costExpected, costActual);
    }

    @Test
    public void testSaveNewEdition() {
        int id = 8;
        String name = "Secreta artis";
        float cost = 780;

        Edition edition = new Edition();
        edition.setId(id);
        edition.setName(name);
        edition.setCost(cost);

        editionService.save(edition);

        Edition editionToCheck = editionService.get(9);
        int idToCheck = editionToCheck.getId();
        String nameToCheck = editionToCheck.getName();
        float costToCheck = editionToCheck.getCost();

        Assert.assertEquals(idToCheck, id);
        Assert.assertEquals(nameToCheck, name);
        Assert.assertEquals(costToCheck, cost);
    }

    @Test
    public void testRemoveEdition() {
        int id = 8;
        String name = "Secreta artis";
        float cost = 780;

        Edition edition = new Edition();
        edition.setId(id);
        edition.setName(name);
        edition.setCost(cost);

        editionService.save(edition);

        editionService.remove(8);
        Edition editionCheck = editionService.get(8);

        Assert.assertNull(editionCheck);
    }

    @Test
    public void testUpdateEdition() {
        String name = "Популярная Механика";
        float cost = 300;

        Edition edition = new Edition();
        edition.setName(name);
        edition.setCost(cost);

        editionService.update(edition, 7);

        Edition editionExpected = editionService.get(7);

        String nameExpected = editionExpected.getName();
        float costExpected = editionExpected.getCost();

        Assert.assertEquals(nameExpected, name);
        Assert.assertEquals(costExpected, cost);

    }

    @Test
    public void testGetListOfEdition() {
        Edition edition = new Edition();
        Edition edition1 = new Edition();
        Edition edition2 = new Edition();

        edition.setId(1);
        edition.setName("Vogue");
        edition.setCost(350);

        edition1.setId(2);
        edition1.setName("Biological Communications");
        edition1.setCost(1300);

        edition2.setId(3);
        edition2.setName("Advanced Materials and Technologies");
        edition2.setCost(2000);

        List<Edition> actual = new ArrayList<>();
        actual.add(edition);
        actual.add(edition1);
        actual.add(edition2);

        List<Edition> expected = editionService.getListOfEdition();

        Assert.assertEquals(expected, actual);
    }
}