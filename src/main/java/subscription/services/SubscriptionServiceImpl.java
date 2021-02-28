package subscription.services;

import subscription.model.Edition;
import subscription.model.Reader;

import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService{

    SubscriptionService subscriptionService = new SubscriptionServiceImpl();

    public List<Edition> getEditionsByUserId(int id){
        return subscriptionService.getEditionsByUserId(id);
    }

    public List<Reader> getReadersByEditionId(int id){
        return subscriptionService.getReadersByEditionId(id);
    }
}
