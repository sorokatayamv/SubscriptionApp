package subscription.services;

import subscription.dao.EditionDao;
import subscription.dao.EditionDaoImpl;
import subscription.model.Edition;

import java.util.List;

public class EditionServiceImpl implements EditionService {
    private EditionDao editionDao = new EditionDaoImpl();

    public Edition get(int id) {
        Edition edition = editionDao.get(id);
        return edition;
    }

    public Edition save(Edition edition) {
        return edition;
    }

    public void remove(int id) {
        editionDao.remove(id);
    }

    public void update(Edition edition, int id) {
        editionDao.update(edition, id);
    }

    @Override
    public List<Edition> getListOfEdition() {
        return editionDao.getListOfEdition();
    }
}
