package model.concrete;

import model.Product;
import utils.ClassOfProduct;

public class Cigar extends Product {
    private ClassOfProduct type = ClassOfProduct.CIGAR;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;
    public Cigar(String name, int id, int price, String description, int quantity) {
        super(name, id, price, description);
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return type+","+super.toString()+","+quantity;
    }
    @Override
    public String displayProductInfo(){
        return super.displayProductInfo() + " | Quantity: " + quantity;
    }
}
