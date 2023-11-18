package FinalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private String orderId;
    private List<Product> products;
    private double totalPrice;
    private User user;

    public Order(String orderId, List<Product> products, double totalPrice, User user) {
        this.orderId = orderId;
        this.products = products;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public Order(User user, ArrayList<Product> products, double totalAmount) {
        this(generateOrderId(), products, totalAmount, user);
    }
    

    // Additional methods, getters, setters, and a method to generate a unique order ID
    public String getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // This method should generate a unique, random order ID
    public static String generateOrderId() {
        Random random = new Random();
        int number = random.nextInt(9000) + 1000; // Generates a number between 1000 and 9999
        return String.valueOf(number);
    }

    public String toString() {
        return "Order ID: " + orderId + "\nProducts: " + products + "\nTotal Price: " + totalPrice + "\nUser: " + user;
    }
    
}
