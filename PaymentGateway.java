package FinalProject;

public interface PaymentGateway {

    boolean processPayment(Order order, double amount);
    
}
