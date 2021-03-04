package subscription.services;

import org.testng.Assert;
import org.testng.annotations.Test;
import subscription.model.Edition;
import subscription.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionServiceImplTest {

    SubscriptionService subscriptionService = new SubscriptionServiceImpl();

    @Test
    public void testGetEditionsByUserId() {
        Edition edition = new Edition();
        Edition edition1 = new Edition();

        edition.setName("Vogue");
        edition1.setName("Biological Communications");

        List<Edition> expected = subscriptionService.getEditionsByUserId(1);

        List<Edition> actual = new ArrayList<>();
        actual.add(edition);
        actual.add(edition1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetReadersByEditionId() {
        Reader reader = new Reader();
        Reader reader1 = new Reader();

        reader.setId(2);
        reader.setSurname("Прокофьев");
        reader.setName("Алексей");
        reader.setPatronymic("Андреевич");

        reader1.setId(6);
        reader1.setSurname("Иванова");
        reader1.setName("Ирина");
        reader1.setPatronymic("Александровна");

        List<Reader> expected = subscriptionService.getReadersByEditionId(3);

        List<Reader> actual = new ArrayList<>();
        actual.add(reader);
        actual.add(reader1);

        Assert.assertEquals(expected, actual);
    }
}