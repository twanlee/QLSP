package service;

import model.Product;

import java.util.List;

public interface ProductService {
    void sort(List<Product> list, Comparator comparator);
    Product find(List<Product> list,String idOrName);
    boolean remove(List<Product> list, String idOrName);
    void edit(List<Product> list);
    void display(List<Product> list);
    void add(List<Product>list, Product product);
}
