package subscription.services;

import subscription.model.Edition;
import subscription.model.Reader;

import java.util.List;

interface SubscriptionService {

   List<Edition> getEditionsByUserId(int id);
   List<Reader> getReadersByEditionId(int id);
}
