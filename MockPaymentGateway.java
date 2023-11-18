package FinalProject;

public class MockPaymentGateway implements PaymentGateway {

    @Override
    public boolean processPayment(Order order, double amount) {
        // Simulate payment processing logic
        System.out.println("Processing payment for Order ID: " + order.getOrderId() + " Amount: $" + amount);
        // Simulate different outcomes of a payment process (success or failure)
        boolean paymentSuccess = simulatePaymentOutcome();
        return paymentSuccess;
    }

    private boolean simulatePaymentOutcome() {
        // Simulate a random outcome of a payment process (success or failure)
        return Math.random() < 0.5;
    }
    
}
