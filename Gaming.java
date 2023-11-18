package FinalProject;

public class Gaming extends Product {
    
    private String gamingSpecificAttributes;

    public Gaming(String id, String name, double price, String electronicSpecificAttributes) {
        super(id, name, price);
        this.gamingSpecificAttributes = electronicSpecificAttributes;
    }

    //getters and setters

    public String getElectronicSpecificAttributes() {
        return gamingSpecificAttributes;
    }

    public void setElectronicSpecificAttributes(String electronicSpecificAttributes) {
        this.gamingSpecificAttributes = electronicSpecificAttributes;
    }

    public String toString() {
        return super.toString() + "\nElectronic Details: " + gamingSpecificAttributes;
    }
    
}



