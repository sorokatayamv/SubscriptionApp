package subscription.services;


import subscription.model.Reader;

import java.util.List;

public class ReaderServiceImpl implements ReaderService{
    private ReaderService readerService = new ReaderServiceImpl();

    public Reader get(int id){
        return readerService.get(id);
    }

    public Reader save(Reader reader){
        return readerService.save(reader);
    }

    public void update(Reader reader){
        readerService.update(reader);
    }

    public void remove(int id){
        readerService.remove(id);
    }

    public List<Reader> getListOfReaders(){
        return readerService.getListOfReaders();
    }

}
