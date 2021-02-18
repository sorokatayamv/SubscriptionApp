package subscription.dao;

import subscription.model.Reader;

import java.util.List;

public interface ReaderDao extends CrudDao<Reader, Integer> {
    @Override
    Reader save(Reader reader);

    @Override
    void update(Reader reader, Integer id);

    @Override
    Reader get(Integer id);

    @Override
    void remove(Integer id);

    public List<Reader> getListOfReaders();
}
