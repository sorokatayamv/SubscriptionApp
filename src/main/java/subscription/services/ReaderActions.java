package subscription.services;

import subscription.model.Reader;

import java.util.Scanner;

public class ReaderActions extends AppRunnerImpl {
    @Override
    public void start() {
        ReaderService readerService = new ReaderServiceImpl();

        System.out.println("If you want to get the reader by surname please input 1.\n" +
                "If you  want to save new reader please input 2.\n" +
                "If you want to remove the reader please input 3.\n" +
                "If you want to update the reader please input 4.\n" +
                "If you want to exit please input 5.\n");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("Please input user surname");
                Scanner scanner = new Scanner(System.in);
                System.out.println(readerService.getReaderBySurname(scanner.nextLine()));
                break;
            case 2:
                Reader reader = new Reader();
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
            case 3:
                System.out.println("Please input user id to remove");
                readerService.remove(sc.nextInt());
                break;

            case 4:
                System.out.println("Please input user id to update");
                Reader readerUpdate = new Reader();
                int readerId = sc.nextInt();
                System.out.println("Please input surname to update");
                readerUpdate.setSurname(sc.nextLine());
                System.out.println("Please input name to update");
                readerUpdate.setName(sc.nextLine());
                System.out.println("Please input patronymic to update");
                readerUpdate.setPatronymic(sc.nextLine());
                readerService.update(readerUpdate, readerId);
                break;

            case 5:
                super.start();
        }
    }
}
