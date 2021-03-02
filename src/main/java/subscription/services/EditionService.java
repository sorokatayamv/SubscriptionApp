package subscription.services;

import subscription.model.Edition;

import java.util.List;

interface EditionService {

    Edition get(int id);

    Edition save(Edition edition);

    void remove(int id);

    void update(Edition edition, int id);

    List<Edition> getListOfEdition();
}

