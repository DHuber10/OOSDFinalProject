package FinalProject;

public class Electronics extends Product {

    private String electronicSpecificAttributes;

    public Electronics(String id, String name, double price, String electronicSpecificAttributes) {
        super(id, name, price);
        this.electronicSpecificAttributes = electronicSpecificAttributes;
    }

    //getters and setters

    public String getElectronicSpecificAttributes() {
        return electronicSpecificAttributes;
    }

    public void setElectronicSpecificAttributes(String electronicSpecificAttributes) {
        this.electronicSpecificAttributes = electronicSpecificAttributes;
    }

    public String toString() {
        return super.toString() + "\nElectronic Details: " + electronicSpecificAttributes;
    }
    
}
