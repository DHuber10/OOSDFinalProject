package FinalProject;

public abstract class Product {

    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getters and setters

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String toString(){
        return "ID: " + id + "\nName: " + name + "\nPrice: " + price;
    }

    
    
}
