package repository.impl;

import model.Book;
import model.Product;
import repository.IGeneralRepository;

import java.io.*;
import java.util.List;
import java.util.SplittableRandom;

public class ProductRepository implements IGeneralRepository {
    @Override
    public void save(List<Product> list) {
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
                String name = attributes[0];
                int id = Integer.parseInt(attributes[1]);
                int price = Integer.parseInt(attributes[2]);
                String description = attributes[3];
                String author = attributes[4];
                list.add(new Book(name,id,author,price,description));
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
