package model.concrete;

import model.Product;
import utils.ClassOfProduct;

public class Book extends Product {
    private ClassOfProduct type = ClassOfProduct.BOOK;
    private String author;
    public Book(String name, int id,String author, int price, String description) {
        super(name, id, price, description);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString(){
        return type+","+super.toString()+","+author;
    }
    @Override
    public String displayProductInfo(){
         return super.displayProductInfo()+" | author: "+author;
    }
}
