package subscription.services;

import java.util.Scanner;

public class SubscriptionActions extends AppRunnerImpl {
    SubscriptionService subscriptionService = new SubscriptionServiceImpl();

    @Override
    public void start() {

        System.out.println("If you want to know what the user is subscribed to, enter 1.\n" +
                "If you want to know who has subscription on edition please input 2.\n" +
                "If you want to exit please input 3.\n");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("Please input user id");
                subscriptionService.getEditionsByUserId(sc.nextInt());
                break;
            case 2:
                System.out.println("Please input edition id");
                subscriptionService.getReadersByEditionId(sc.nextInt());
                break;
            case 3:
                super.start();
        }

    }
}
