package subscription;

import subscription.services.AppRunnerImpl;

public class Main {
    public static void main(String[] args) {
        AppRunnerImpl appRunner = new AppRunnerImpl();
        appRunner.start();
    }
}
