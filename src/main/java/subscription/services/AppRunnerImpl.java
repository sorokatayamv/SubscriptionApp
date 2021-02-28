package subscription.services;

import subscription.model.Reader;
import java.util.Scanner;

public class AppRunnerImpl implements AppRunner{
    Scanner sc = new Scanner(System.in);
    int userInputStart = sc.nextInt();
    ReaderService readerService = new ReaderServiceImpl();
    EditionService editionService = new EditionServiceImpl();
    SubscriptionService subscriptionService = new SubscriptionServiceImpl();
    @Override
    public void start() {
        System.out.println("Hello! If you want to get some information about readers please input 1." +
                "If you want to get some information about editions please input 2." +
                "If you want to get some information about subscription please input 3.");
        if(userInputStart == 1){
            ReaderActions readerActions = new ReaderActions();
            readerActions.start();
        }
        if(userInputStart == 2){
            EditionActions editionActions = new EditionActions();
            editionActions.start();
        }
        if(userInputStart == 3){
            SubscriptionActions subscriptionActions = new SubscriptionActions();
            subscriptionActions.start();
        }
    }
}
