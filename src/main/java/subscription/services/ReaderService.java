package subscription.services;

import subscription.model.Reader;

import java.util.List;

interface ReaderService {
    Reader get(int id);

    Reader save(Reader reader);

    void update(Reader reader, int id);

    void remove(int id);

    List<Reader> getListOfReaders();

    List<Reader> getReaderBySurname(String surname);
}
