package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static ShoppingCart instance;
    private List<Product> products;
    private Logger logger;

    private ShoppingCart(Logger logger) {
        products = new ArrayList<>();
        this.logger = logger;
    }

    public static ShoppingCart getInstance(Logger logger) {
        if (instance == null) {
            instance = new ShoppingCart(logger);
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        logger.log("Product added to cart: " + product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        logger.log("Product removed from cart: " + product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void clearCart() {
        products.clear();
    }
    
}
