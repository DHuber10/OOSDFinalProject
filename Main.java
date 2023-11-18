package FinalProject;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // Initialize services and components
        Logger logger = new FileLogger("C:\\Users\\dhube\\OneDrive\\Desktop\\ShoppingCart\\Logger.txt");
        AuthenticationService authService = new AuthenticationServiceImpl(logger);
        ProductFactory productFactory = new ProductFactory();
        ProductCatalog productCatalog = new ProductCatalogImpl(); 
        ShoppingCart cart = ShoppingCart.getInstance(logger);
        OrderService orderService = new OrderService(logger, productFactory);
        PaymentGateway paymentGateway = new MockPaymentGateway();
        PaymentService paymentService = new PaymentService(paymentGateway);
        User currentUser = null; // To keep track of logged-in user

        
        productCatalog.addProduct(new Electronics("1", "Smartphone", 999.99, "iPhone 15"));
        productCatalog.addProduct(new Electronics("4", "Laptop", 1499.99, "Lenovo ThinkPad"));
        productCatalog.addProduct(new Clothing("2", "T-Shirt", 29.99, "Cotton, Size: M"));
        productCatalog.addProduct(new Gaming("3", "PS5", 499.99, "60 FPS 4K Gaming"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: \n1. Register \n2. Login \n3. Browse Products \n4. Add to Cart \n5. Empty Cart \n6. View Cart \n7. Checkout \n8. Exit ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Handle user registration
                    System.out.println("Register new user");
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    User newUser = new User(newUsername, newPassword, email);
                    boolean registrationSuccess = authService.register(newUser);
                    if (registrationSuccess) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed. Username may already be taken.");
                    }
                    break;

                case 2:
                    // Handle user login
                    System.out.println("User login");
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    boolean loginSuccess = authService.login(username, password);
                    if (loginSuccess) {
                        System.out.println("Login successful.");
                        currentUser = new User(username, password, ""); // assuming email is not necessary for session
                    } else {
                        System.out.println("Login failed. Check your username and password.");
                    }
                    break;

                case 3:
                    // Handle browsing products
                    System.out.println("Product Catalog:");
                    for (Product product : productCatalog.getAllProducts()) { 
                        System.out.println(product);
                    }
                    break;

                case 4:
                    // Add product to cart
                    System.out.println("Enter the ID of the product to add to the cart:");
                    String productId = scanner.nextLine();
                    Product product = productCatalog.getProductById(productId);
                    if (product != null) {
                        cart.addProduct(product);
                        System.out.println("Product added to cart: " + product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    // Emply cart
                    System.out.println("Empty cart: ");
                    cart.clearCart();
                    break;

                case 6:
                    // View cart contents
                    System.out.println("Cart Contents:");
                    cart.printProducts();
                    break;


                case 7:
                    // Checkout (create order and process payment)
                    if (currentUser != null && !cart.getProducts().isEmpty()) {
                        Order order = orderService.createOrder(currentUser, cart);
                        
                        boolean paymentProcessed = paymentService.processOrderPayment(order);
                        if (paymentProcessed) {
                            System.out.println("Payment processed successfully for Order ID: " + order.getOrderId());
                        } else {
                            System.out.println("Payment failed for Order ID: " + order.getOrderId());
                        }
                    } else {
                        System.out.println("Please login and make sure your cart is not empty.");
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}