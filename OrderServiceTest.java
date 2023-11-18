package FinalProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class OrderServiceTest {

    private OrderService orderService;
    private ShoppingCart cart;
    private User user;
    private Product smartphone;
    private Product tshirt;

    @BeforeEach
    void setUp() {
        Logger logger = new ConsoleLogger();
        ProductFactory productFactory = new ProductFactory();
        orderService = new OrderService(logger, productFactory);
        cart = ShoppingCart.getInstance(logger);
        user = new User("testuser", "password", "testuser@example.com");
        smartphone = new Electronics("1", "Smartphone", 999.99, "Latest model");
        tshirt = new Clothing("2", "T-Shirt", 29.99, "Cotton, Size: M");
        cart.clearCart(); // Clear the cart before each test
    }

    @Test
    void testCreateOrderWithProducts() {
        cart.addProduct(smartphone);
        cart.addProduct(tshirt);
        Order order = orderService.createOrder(user, cart);
        assertNotNull(order, "Order should not be null");
        assertEquals(2, order.getProducts().size(), "Order should contain two products");
    }

    @Test
    void testCreateOrderWithEmptyCart() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            orderService.createOrder(user, cart);
        });
        assertEquals("Cart is empty", exception.getMessage(), "Creating an order with an empty cart should throw an exception");
    }

    @Test
    void testOrderTotalPrice() {
        cart.addProduct(smartphone);
        Order order = orderService.createOrder(user, cart);
        assertEquals(smartphone.getPrice(), order.getTotalPrice(), "Total price of the order should match the product price");
    }
}
