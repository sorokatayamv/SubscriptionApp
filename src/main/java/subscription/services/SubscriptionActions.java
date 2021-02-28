package subscription.services;

public class SubscriptionActions extends AppRunnerImpl{
    @Override
    public void start() {
        super.start();
        System.out.println("If you want to know what the user is subscribed to, enter 1." +
                "If you want to know who has subscription on edition please input 2.");
        int userInput = sc.nextInt();
        if(userInput == 1){
            System.out.println("Please input user id");
            subscriptionService.getEditionsByUserId(sc.nextInt());
        }

        if(userInput == 2){
            System.out.println("Please input edition id");
            subscriptionService.getReadersByEditionId(sc.nextInt());
        }
    }
}
