package subscription.services;

import java.util.Scanner;

public class AppRunnerImpl implements AppRunner {

    @Override
    public void start() {
        System.out.println("Hello! If you want to get some information about readers please input 1.\n" +
                "If you want to get some information about editions please input 2.\n" +
                "If you want to get some information about subscription please input 3.\n" +
                "If you want to exit please input 4. \n");
        Scanner sc = new Scanner(System.in);
        int userInputStart = sc.nextInt();
        while (true) {
            if (userInputStart == 1) {
                ReaderActions readerActions = new ReaderActions();
                readerActions.start();
            }
            if (userInputStart == 2) {
                EditionActions editionActions = new EditionActions();
                editionActions.start();
            }
            if (userInputStart == 3) {
                SubscriptionActions subscriptionActions = new SubscriptionActions();
                subscriptionActions.start();
            }
            if (userInputStart == 4) {
                break;
            }
        }
    }
}
