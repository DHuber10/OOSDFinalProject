package FinalProject;

import java.util.List;

public interface ProductCatalog {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();
    
}
