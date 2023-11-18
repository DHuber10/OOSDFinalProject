package FinalProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product smartphone;
    private Product tshirt;

    @BeforeEach
    void setUp() {
        Logger logger = new ConsoleLogger(); // Or use a mock logger
        cart = ShoppingCart.getInstance(logger);
        smartphone = new Electronics("1", "Smartphone", 999.99, "Latest model");
        tshirt = new Clothing("2", "T-Shirt", 29.99, "Cotton, Size: M");
        cart.clearCart(); // Clear the cart before each test
    }

    @Test
    void testAddProduct() {
        cart.addProduct(smartphone);
        assertTrue(cart.getProducts().contains(smartphone), "Smartphone should be added to the cart");
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct(tshirt);
        cart.removeProduct(tshirt);
        assertFalse(cart.getProducts().contains(tshirt), "T-Shirt should be removed from the cart");
    }

    @Test
    void testCartIsEmptyAfterClear() {
        cart.addProduct(smartphone);
        cart.clearCart();
        assertTrue(cart.getProducts().isEmpty(), "Cart should be empty after clearing");
    }

    @Test
    void testMultipleProducts() {
        cart.addProduct(smartphone);
        cart.addProduct(tshirt);
        assertEquals(2, cart.getProducts().size(), "Cart should contain two products");
    }

    @Test
    void testTotalPriceCalculation() {
        cart.addProduct(smartphone);
        cart.addProduct(tshirt);
        double expectedTotal = smartphone.getPrice() + tshirt.getPrice();
        assertEquals(expectedTotal, cart.getTotalPrice(), "Total price should be the sum of the product prices");
    }
}

