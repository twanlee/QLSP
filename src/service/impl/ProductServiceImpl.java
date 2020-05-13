package service.impl;

import model.Product;
import service.Comparator;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public void sort(List<Product> list, Comparator comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public Product find(List<Product> products, String idOrName) {
        for (Product product : products) {
            if (product.getName().equals(idOrName) || Integer.toString(product.getId()).equals(idOrName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean remove(List<Product> list, String idOrName) {
        Product product = this.find(list, idOrName);
        if (product != null) {
            list.remove(product);
            return true;
        } else
            return false;
    }

    @Override
    public void update(List<Product> list, Product product, int id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            list.get(index).setName(product.getName());
            list.get(index).setDescription(product.getDescription());
            list.get(index).setPrice(product.getPrice());
        }

    }

    public void display(List<Product> list) {
        for (Product x : list) {
            System.out.println(x.displayProductInfo());
        }
    }

    @Override
    public void add(List<Product> list, Product product) {
        Product productCheck1 = find(list, product.getName());
        Product productCheck2 = find(list, Integer.toString(product.getId()));
        if (productCheck1 == null || productCheck2 == null) {
            list.add(product);
            System.out.println("Done");
        } else
            System.out.println("Duplicate product! ");

    }
}
