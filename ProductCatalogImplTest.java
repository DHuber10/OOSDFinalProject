package FinalProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ProductCatalogImplTest {

    private ProductCatalog catalog;
    private Product smartphone;
    private Product tshirt;

    @BeforeEach
    void setUp() {
        catalog = new ProductCatalogImpl();
        smartphone = new Electronics("1", "Smartphone", 999.99, "Latest model");
        tshirt = new Clothing("2", "T-Shirt", 29.99, "Cotton, Size: M");
    }

    @Test
    void testAddAndGetProduct() {
        catalog.addProduct(smartphone);
        assertEquals(smartphone, catalog.getProductById("1"), "Retrieved smartphone should match the added product");
    }

    @Test
    void testGetNonExistentProduct() {
        assertNull(catalog.getProductById("3"), "Getting a non-existent product should return null");
    }

    @Test
    void testAddMultipleProducts() {
        catalog.addProduct(smartphone);
        catalog.addProduct(tshirt);
        assertNotNull(catalog.getProductById("1"), "Smartphone should be retrievable");
        assertNotNull(catalog.getProductById("2"), "T-Shirt should be retrievable");
    }
}

