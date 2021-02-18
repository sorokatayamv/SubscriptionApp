package subscription;

import subscription.dao.*;
import subscription.model.Edition;

public class Main {
    public static void main(String[] args){
        SubscriptionDao dao = new SubscriptionDaoImpl();
        dao.getReaderByEditionId(2);
        dao.getEditionsByUserId(2);

        EditionDao daoEd = new EditionDaoImpl();
        daoEd.get(1);

        ReaderDao rd = new ReaderDaoImpl();
        rd.getListOfReaders();

        rd.get(5);
    }
}
