package model;

import utils.ClassOfProduct;

public abstract class Product {
    private ClassOfProduct type;
    private String name;
    private int id;
    private int price;
    private String description;

    public Product(String name, int id, int price, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return name+","+id+","+price+","+description;
    }
    public String  displayProductInfo(){
        return "Name: " + name + " | ID " + id + " | Price: " + price+" | Description: " + description;
    }
}
