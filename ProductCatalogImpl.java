package FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ProductCatalogImpl implements ProductCatalog {

    private Map<String, Product> products;

    public ProductCatalogImpl() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
    
}
