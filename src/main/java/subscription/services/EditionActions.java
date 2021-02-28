package subscription.services;

import subscription.model.Edition;

public class EditionActions extends AppRunnerImpl {
    @Override
    public void start() {
        //TODO: super.start()?
        super.start();
        System.out.println("If you want to get the edition by id please input 1" +
                "If you want to save new edition please input 2" +
                "If you want to remove the edition please input 3" +
                "If you want to update the edition please input 4");
        int userInput = sc.nextInt();

        switch(userInput){
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
                editionUpdate.setId(sc.nextInt());
                System.out.println("Please input edition name");
                editionUpdate.setName(sc.nextLine());
                System.out.println("Please input edition cost");
                editionUpdate.setCost(sc.nextFloat());
                editionService.update(editionUpdate);
                break;
        }
    }
}
