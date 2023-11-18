package FinalProject;

import java.util.ArrayList;


public class ShoppingCartBuilder {
    
    private ShoppingCart cart;
    private User customer;

    public ShoppingCartBuilder(User customer) {
        this.customer = customer;
        this.cart = ShoppingCart.getInstance(null);
        this.cart.clearCart();

    }

    public ShoppingCartBuilder addProduct(Product product) {
        this.cart.getProducts().add(product);
        return this;
    }

    public ShoppingCartBuilder removeProduct(Product product) {
        this.cart.getProducts().remove(product);
        return this;
    }

    public ShoppingCartBuilder setCustomer(User customer) {
        this.customer = customer;
        return this;
    }

    public Order finalizeOrder() {
        if (cart.getProducts().isEmpty()) {
            throw new IllegalStateException("Cannot finalize order with an empty cart.");
        }

        // Here, you might include additional logic for finalizing the order,
        // such as setting order details, calculating totals, etc.
        Order order = new Order(customer, new ArrayList<>(cart.getProducts()), calculateTotal());
        // Clear the cart after finalizing the order
        cart.clearCart();

        return order;
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Product product : cart.getProducts()) {
            total += product.getPrice();
        }
        return total;
    }

}
