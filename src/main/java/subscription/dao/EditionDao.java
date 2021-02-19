package subscription.dao;

import subscription.model.Edition;

import java.util.List;

public interface EditionDao extends CrudDao<Edition, Integer> {
    @Override
    Edition save(Edition edition);

    @Override
    Edition get(Integer id);

    @Override
    void update(Edition edition, Integer id);

    @Override
    void remove(Integer id);

    List<Edition> getListOfEdition();

}

