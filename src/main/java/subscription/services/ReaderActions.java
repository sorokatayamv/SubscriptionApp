package subscription.services;

import subscription.model.Reader;

public class ReaderActions extends AppRunnerImpl{
    @Override
    public void start() {
        super.start();
        System.out.println("If you want to get the reader by id please input 1" +
                "If you want to save new reader please input 2" +
                "If you want to remove the reader please input 3" +
                "If you want to update the reader please input 4");
        int userInput = sc.nextInt();
        switch (userInput){
            //TODO: interface service
            case 1: System.out.println("Please input user id");
                readerService.get(sc.nextInt());
                break;
            case 2: Reader reader = new Reader();
                System.out.println("Please input new user id");
                reader.setId(sc.nextInt());
                System.out.println("Please input new user surname");
                reader.setSurname(sc.nextLine());
                System.out.println("Please input new user name");
                reader.setName(sc.nextLine());
                System.out.println("Please input new user patronymic");
                reader.setPatronymic(sc.nextLine());
                readerService.save(reader);
                break;
            case 3: System.out.println("Please input user id to remove");
                readerService.remove(sc.nextInt());
                break;
            //TODO: update?
            case 4: System.out.println("Please input user id to update");
                Reader readerUpdate = new Reader();
                readerUpdate.setId(sc.nextInt());
                System.out.println("Please input surname to update");
                readerUpdate.setSurname(sc.nextLine());
                System.out.println("Please input name to update");
                readerUpdate.setName(sc.nextLine());
                System.out.println("Please input patronymic to update");
                readerUpdate.setPatronymic(sc.nextLine());
                readerService.update(readerUpdate);
                break;
        }
    }
}
