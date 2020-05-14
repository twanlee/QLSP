package service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;
import model.Product;
import model.concrete.Book;
import model.concrete.Cigar;
import service.Comparator;
import service.ProductService;
import utils.ClassOfProduct;

import java.util.List;
import java.util.Scanner;

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
            if (product.getName().equals(idOrName) || Integer.toString(product.getId()).equals(idOrName)){
                return product;
            }
        }return null;
    }


    @Override
    public boolean remove(List<Product> list, String idOrName) {
        Product productCheck = this.find(list, idOrName);
        if (productCheck != null) {
            list.remove(productCheck);
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
            list.get(index).setId(product.getId());
        }

    }

    public void display(List<Product> list) {
        for (Product product : list) {
            if(checkType(product) ==ClassOfProduct.BOOK ){
                product = (Book) product;
                System.out.println(product.displayProductInfo());
            }else if (checkType(product) == ClassOfProduct.CIGAR){
                product = (Cigar) product;
                System.out.println(product.displayProductInfo());
            }
        }
    }

    @Override
    public void add(List<Product> list, Product product) {
        Product product1 = find(list, product.getName());
        Product product2 = find(list, Integer.toString(product.getId()));
        if (product1 == null && product2 == null) {
            list.add(product);
            System.out.println("Done");
        } else
            System.out.println("Duplicate product! ");

    }


    @Override
    public Product factoryProduct(ClassOfProduct classOfProduct) {
        Scanner scanner = new Scanner(System.in);
        if(classOfProduct==ClassOfProduct.BOOK){
            System.out.println("Enter Name: ");
             String name = scanner.nextLine();
            System.out.println("Enter ID: ");
             int id = scanner.nextInt();
            System.out.println("Enter Price: ");
            scanner.nextLine();
             int price = scanner.nextInt();
            System.out.println("Enter description: ");
            scanner.nextLine();
             String description = scanner.nextLine();
            System.out.println("Enter the Author: ");
             String author = scanner.nextLine();
            return new Book(name,id,author,price,description);
        }else if(classOfProduct==ClassOfProduct.CIGAR){
            System.out.println("Enter Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter ID: ");
            int id = scanner.nextInt();
            System.out.println("Enter Price: ");
            scanner.nextLine();
            int price = scanner.nextInt();
            System.out.println("Enter description: ");
            scanner.nextLine();
            String description = scanner.nextLine();
            System.out.println("Enter quantity: ");

            int quantity = scanner.nextInt();
            return new Cigar(name,id,price,description,quantity);
        }
        return null;

    }

    @Override
    public ClassOfProduct checkType(Product product) {
        if(product instanceof Book) return ClassOfProduct.BOOK;
        else if(product instanceof Cigar) return ClassOfProduct.CIGAR;
        else return null;
    }


}
