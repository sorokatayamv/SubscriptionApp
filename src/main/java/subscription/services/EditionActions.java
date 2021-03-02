package subscription.services;

import subscription.model.Edition;

import java.util.Scanner;

public class EditionActions extends AppRunnerImpl {
    EditionService editionService = new EditionServiceImpl();

    @Override
    public void start() {

        System.out.println("If you want to get the edition by id please input 1.\n" +
                "If you want to save new edition please input 2.\n" +
                "If you want to remove the edition please input 3.\n" +
                "If you want to update the edition please input 4.\n" +
                "If you want to exit please input 5.\n");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("Please input edition id");
                editionService.get(sc.nextInt());
                break;
            case 2:
                Edition edition = new Edition();
                System.out.println("Please input edition id");
                edition.setId(sc.nextInt());
                System.out.println("Please input edition name");
                edition.setName(sc.nextLine());
                System.out.println("Please input edition cost");
                edition.setCost(sc.nextFloat());
                editionService.save(edition);
                break;
            case 3:
                System.out.println("Please input edition id to remove");
                editionService.remove(sc.nextInt());
                break;
            case 4:
                System.out.println("Please input edition id to update");
                Edition editionUpdate = new Edition();
                int editionId = sc.nextInt();
                System.out.println("Please input edition name");
                editionUpdate.setName(sc.nextLine());
                System.out.println("Please input edition cost");
                editionUpdate.setCost(sc.nextFloat());
                editionService.update(editionUpdate, editionId);
                break;
            case 5:
                super.start();
        }
    }
}
