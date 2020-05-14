package controller;

import model.Product;
import service.Comparator;
import service.impl.ProductServiceImpl;
import utils.ClassOfProduct;

import java.util.List;

public class ProductController {
    ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    public void sort(List<Product> list, Comparator comparator){
        productServiceImpl.sort(list,comparator);
    }
    public Product find(List<Product> list, String idOrName){
        return productServiceImpl.find(list,idOrName);
    }
    public boolean remove(List<Product> list, String idOrName){
        return productServiceImpl.remove(list,idOrName);
    }
    public void update(List<Product> list, Product product, int id){
        productServiceImpl.update(list,product,id);
    }
    public void display(List<Product> list){
        productServiceImpl.display(list);
    }
    public void add(List<Product> list, Product product){
        productServiceImpl.add(list,product);
    }

    public Product factoryProduct(ClassOfProduct classOfProduct){
        return productServiceImpl.factoryProduct(classOfProduct);
    }
    public ClassOfProduct checkType(Product product){
        return productServiceImpl.checkType(product);
    }
}
