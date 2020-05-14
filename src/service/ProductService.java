package service;

import model.Product;
import utils.ClassOfProduct;
import java.util.List;

public interface ProductService {
    void sort(List<Product> list, Comparator comparator);

    Product find(List<Product> products, String idOrName);

    boolean remove(List<Product> list, String idOrName);
    void update(List<Product> list, Product product, int id);
    void display(List<Product> list);
    void add(List<Product>list, Product product);
    Product factoryProduct(ClassOfProduct classOfProduct);
    ClassOfProduct checkType(Product product);
    
}
