package subscription.services;

import subscription.dao.SubscriptionDao;
import subscription.dao.SubscriptionDaoImpl;
import subscription.model.Edition;
import subscription.model.Reader;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {

    SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();

    public List<Edition> getEditionsByUserId(int id) {
        return subscriptionDao.getEditionsByUserId(id);
    }

    public List<Reader> getReadersByEditionId(int id) {
        return subscriptionDao.getReaderByEditionId(id);
    }
}
