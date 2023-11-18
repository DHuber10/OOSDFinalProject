package FinalProject;

public class Clothing extends Product {

    private String clothingSpecificAttributes;

    public Clothing(String id, String name, double price, String clothingSpecificAttributes) {
        super(id, name, price);
        this.clothingSpecificAttributes = clothingSpecificAttributes;
    }

    //getters and setters

    public String getClothingSpecificAttributes() {
        return clothingSpecificAttributes;
    }

    public void setClothingSpecificAttributes(String clothingSpecificAttributes) {
        this.clothingSpecificAttributes = clothingSpecificAttributes;
    }

    public String toString() {
        return super.toString() + "\nClothing Details: " + clothingSpecificAttributes;
    }
    
}
