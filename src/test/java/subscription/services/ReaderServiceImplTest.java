package subscription.services;

import org.testng.Assert;
import org.testng.annotations.Test;
import subscription.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImplTest {

    ReaderService readerService = new ReaderServiceImpl();

    @Test
    public void testGetReaderById() {

        int idActual = 1;
        String surnameActual = "Денисова";
        String nameActual = "Екатерина";
        String patronymicActual = "Ивановна";

        Reader readerExpected = readerService.get(1);

        int idExpected = readerExpected.getId();
        String surnameExpected = readerExpected.getSurname();
        String nameExpected = readerExpected.getName();
        String patronymicExpected = readerExpected.getPatronymic();

        Assert.assertEquals(idExpected, idActual);
        Assert.assertEquals(surnameExpected, surnameActual);
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertEquals(patronymicExpected, patronymicActual);
    }

    @Test
    public void testSaveNewReader() {
        int id = 11;
        String surname = "Ворошилов";
        String name = "Николай";
        String patronymic = "Николаевич";

        Reader readerToSave = new Reader();
        readerToSave.setId(id);
        readerToSave.setSurname(surname);
        readerToSave.setName(name);
        readerToSave.setPatronymic(patronymic);

        readerService.save(readerToSave);

        Reader readerToCheck = readerService.get(11);
        int idCheck = readerToCheck.getId();
        String surnameCheck = readerToCheck.getSurname();
        String nameCheck = readerToCheck.getName();
        String patronymicCheck = readerToCheck.getPatronymic();

        Assert.assertEquals(idCheck, id);
        Assert.assertEquals(surnameCheck, surname);
        Assert.assertEquals(nameCheck, name);
        Assert.assertEquals(patronymicCheck, patronymic);
    }

    @Test
    public void testUpdateReader() {
        String surnameActual = "Кравцова";
        String nameActual = "Мария";
        String patronymicActual = "Данииловна";

        Reader readerUpdate = new Reader();
        readerUpdate.setSurname(surnameActual);
        readerUpdate.setName(nameActual);
        readerUpdate.setPatronymic(patronymicActual);
        readerService.update(readerUpdate, 9);

        Reader readerExpected = readerService.get(9);
        String surnameExpected = readerExpected.getSurname();
        String nameExpected = readerExpected.getName();
        String patronymicExpected = readerExpected.getPatronymic();

        Assert.assertEquals(surnameExpected,surnameActual);
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertEquals(patronymicExpected, patronymicActual);
    }

    @Test
    public void testRemoveReader() {
        int id = 11;
        readerService.remove(id);
        Reader readerCheck = readerService.get(id);
        Assert.assertNull(readerCheck);
    }

    @Test
    public void testGetListOfReaders() {
        Reader reader = new Reader();
        Reader reader1 = new Reader();
        Reader reader2 = new Reader();

        reader.setSurname("Денисова");
        reader.setName("Екатерина");
        reader.setPatronymic("Ивановна");

        reader1.setSurname("Прокофьев");
        reader1.setName("Алексей");
        reader1.setPatronymic("Андреевич");

        reader2.setSurname("Белоусова");
        reader2.setName("Елена");
        reader2.setPatronymic("Александровна");

       List<Reader> actual = new ArrayList<>();
       actual.add(reader);
       actual.add(reader1);
       actual.add(reader2);

        List<Reader> expected = readerService.getListOfReaders();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetReaderBySurname() {
        String surname = "Денисова";

        String surnameActual = "Денисова";
        String nameActual = "Екатерина";
        String patronymicActual = "Ивановна";

        List<Reader> readerExpectedList = readerService.getReaderBySurname(surname);
        Reader readerExpected = readerExpectedList.get(0);
        String surnameExpected = readerExpected.getSurname();
        String nameExpected = readerExpected.getName();
        String patronymicExpected = readerExpected.getPatronymic();

        Assert.assertEquals(surnameExpected, surnameActual);
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertEquals(patronymicExpected, patronymicActual);
    }
}