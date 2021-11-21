package domain.notifier;

public class EmailNotifierEngineFactory {

    private EmailNotifierEngineFactory() {
        throw new AssertionError();
    }

    public static EmailNotifierEngine withPaymentEmailNotifier() {
        return new PaymentEmailNotifierEngine();
    }

    public static EmailNotifierEngine withRegisteredEmailNotifier() {
        return new RegisteredEmailNotifierEngine();
    }
}
