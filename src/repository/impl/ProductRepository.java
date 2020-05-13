package repository.impl;

import model.concrete.Book;
import model.Product;
import model.concrete.Cigar;
import repository.IGeneralRepository;
import utils.ClassOfProduct;

import java.io.*;
import java.util.List;

public class ProductRepository implements IGeneralRepository {
    @Override
    public synchronized void save(List<Product> list) {
        try {
            PrintStream ps = new PrintStream("Products");
            for (Product product: list){
                ps.println(product.toString());
            }
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void load(List<Product> list) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Products"));
            String line ;
            while ((line=bufferedReader.readLine()) != null){
                String[] attributes = line.split(",");
                String type = attributes[0];
                if(type.equalsIgnoreCase(String.valueOf(ClassOfProduct.BOOK))){
                    String name = attributes[1];
                    int id = Integer.parseInt(attributes[2]);
                    int price = Integer.parseInt(attributes[3]);
                    String description = attributes[4];
                    String author = attributes[5];
                    list.add(new Book(name,id,author,price,description));
                }else if(type.equalsIgnoreCase(String.valueOf(ClassOfProduct.CIGAR))){
                    String name = attributes[1];
                    int id = Integer.parseInt(attributes[2]);
                    int price = Integer.parseInt(attributes[3]);
                    String description = attributes[4];
                    int quantity = Integer.parseInt(attributes[5]);
                    list.add(new Cigar(name,id,price,description,quantity));
                }

            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
