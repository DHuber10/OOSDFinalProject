package FinalProject;

public class ProductFactory {

    public Product createProduct(String type, String id, String name, double price) {
        switch (type.toLowerCase()) {
            case "clothing":
                return new Clothing(id, name, price, "clothing specific attributes");
            case "electronics":
                return new Electronics(id, name, price, "electronic specific attributes");
            case "gaming":
                return new Gaming(id, name, price, "gaming specific attributes"); 
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
    
}
