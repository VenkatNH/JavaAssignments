package assignmentFour.model;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Item {
    private double price;
    private double tax;
    private String name;
    private String type;
    private int quantity;

    public Item(String name, Double price, int quantity, String type){
        this.price = price;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.tax = 0.0;
    }

    public void setTax(double val){
        tax = val;
    }
    void setName(String val){
        name = val;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }

    public double getTax() {
        return tax;
    }

    public int getQuantity() {
        return quantity;
    }
}
