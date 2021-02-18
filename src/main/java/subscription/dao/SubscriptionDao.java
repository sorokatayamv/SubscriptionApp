package subscription.dao;

import subscription.model.Edition;
import subscription.model.Reader;

import java.util.List;

public interface SubscriptionDao {

   List<Edition> getEditionsByUserId(int id);
   List<Reader> getReaderByEditionId(int id);
}
