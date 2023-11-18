package FinalProject;

public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processOrderPayment(Order order) {
        double amount = order.getTotalPrice();
        return paymentGateway.processPayment(order, amount);
    }
    
}
