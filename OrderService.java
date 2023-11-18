package FinalProject;

import java.util.ArrayList;


public class OrderService {
    private Logger logger;
    private ProductFactory productFactory;

    public OrderService(Logger logger, ProductFactory productFactory) {
        this.productFactory = productFactory;
        this.logger = logger;
    }

    public Order createOrder(User user, ShoppingCart cart) {
        logger.log("Attempting to create order for user: " + user.getUsername());

        if (cart.getProducts().isEmpty()) {
            logger.log("Order creation failed - Cart is empty for user: " + user.getUsername());
            throw new IllegalStateException("Cart is empty");
        }

        double totalAmount = calculateTotal(cart);
        Order order = new Order(user, new ArrayList<>(cart.getProducts()), totalAmount);

        logger.log("Order created successfully for user: " + user.getUsername() + " with Order ID: " + order.getOrderId());
        return order;
    }
    private double calculateTotal(ShoppingCart cart) {
        double total = 0.0;
        for (Product product : cart.getProducts()) {
            total += product.getPrice();
        }
        logger.log("Total amount for cart calculated: $" + total);
        return total;
    }
    

    // Additional methods for order processing
    public void processOrder(Order order) {
        // Implementation to process the order
        System.out.println("Order processed");
    }

    public void cancelOrder(Order order) {
        // Implementation to cancel the order
        System.out.println("Order cancelled");
    }

    public void shipOrder(Order order) {
        // Implementation to ship the order
        System.out.println("Order shipped");
    }

    public void deliverOrder(Order order) {
        // Implementation to deliver the order
        System.out.println("Order delivered");
    }

    public void returnOrder(Order order) {
        // Implementation to return the order
        System.out.println("Order returned");
    }

}
