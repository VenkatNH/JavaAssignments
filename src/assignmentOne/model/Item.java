package assignmentOne.model;

/**
 * Created by venkatdatta on 05/07/17.
 */
public class Item {
    private double price;
    private double tax;
    private String name;
    private String type;
    private int quantity;

    public void setPrice(double val){
        price = val;
    }
    public void setTax(double val){
        tax = val;
    }
    public void setName(String val){
        name = val;
    }
    public void setType(String val){
        type = val;
    }
    public void setQuantity(int val){
        quantity = val;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public double getTax(){
        return tax;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
}
