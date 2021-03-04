package subscription.services;


import subscription.dao.interfaces.ReaderDao;
import subscription.dao.implementation.ReaderDaoImpl;
import subscription.model.Reader;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private ReaderDao readerDao = new ReaderDaoImpl();

    public Reader get(int id) {
        return readerDao.get(id);
    }

    public Reader save(Reader reader) {
        return readerDao.save(reader);
    }

    public void update(Reader reader, int id) {
        readerDao.update(reader, id);
    }

    public void remove(int id) {
        readerDao.remove(id);
    }

    @Override
    public List<Reader> getListOfReaders() {
        return readerDao.getListOfReaders();
    }

    @Override
    public List<Reader> getReaderBySurname(String surname) {
        return readerDao.getReaderBySurname(surname);
    }
}
