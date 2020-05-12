package model;

public class Book extends Product{
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
        return super.toString()+","+author;
    }
}
