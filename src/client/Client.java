package client;

import controller.ProductController;
import model.Product;
import model.concrete.Book;
import model.concrete.Cigar;
import repository.impl.ProductRepository;
import service.impl.ProductNameComparator;
import service.impl.ProductPriceComparator;
import utils.ClassOfProduct;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    Scanner sc = new Scanner(System.in);
    List<Product> myProducts = new ArrayList<>();
    ProductController productController = new ProductController();
    ProductRepository productRepository = new ProductRepository();
    ProductPriceComparator productPriceComparator = new ProductPriceComparator();
    ProductNameComparator productNameComparator = new ProductNameComparator();


    public final String adminPassword = "123";
    public final String staffPassword = "111";
    public String filePath = "D:\\Code Gym\\Git\\Module 2\\Java\\QLSP\\Products";
    File file = new File(filePath);

    public boolean checkFirstTime(){
        if(file.length()==0){
            return true;
        }else return false;
    }
    public void menu(){
        System.out.println("======Menu======");
        System.out.println("Identify yourself");
        System.out.println("1. Admin");
        System.out.println("2. Staff");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                adminLogin();
                break;
            case 2:
                staffLogin();
                break;
            default:
                System.out.println("Enter 1 or 2");
                menu();
        }
    }
    public void adminLogin(){
        System.out.println("Enter password: ");
        sc.nextLine();
        String password = sc.nextLine();
        if(password.equals(adminPassword)){
            adminMenu();
        }else {
            System.out.println("Wrong password! Check again!");
            adminLogin();
        }
    }
    public void staffLogin(){
        System.out.println("Enter password: ");
        String password = sc.next();
        if (password.equals(staffPassword)){
            staffMenu();
        }
        else {
            System.out.println("Wrong password! Check again!");
            staffLogin();
        }
    }
    public void adminMenu(){
        System.out.println("1. ");
    }
    public void staffMenu(){
        if (checkFirstTime()) {
            System.out.println("First time running! Please add a new Product");
            System.out.println("-------");
            addNewProduct();
        }else {
            while (true) {
                productRepository.load(myProducts);
                System.out.println("=====Menu====");
                System.out.println("1. Sort by Price");
                System.out.println("2. Sort by Name");
                System.out.println("3. Find a product by ID or Name");
                System.out.println("4. Display all of products");
                System.out.println("5. Update product");
                System.out.println("6. Add a new product");
                System.out.println("0. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                    productController.sort(myProducts,productPriceComparator);
                    productController.display(myProducts);
                    productRepository.save(myProducts);
                    break;
                    case 2:
                        productController.sort(myProducts,productNameComparator);
                        productController.display(myProducts);
                        productRepository.save(myProducts);
                        break;
                    case 3:
                        System.out.println("Enter product ID or Name");
                        sc.nextLine();
                        String idOrName = sc.nextLine();
                        Product product = productController.find(myProducts,idOrName);
                        if(productController.checkType(product)==ClassOfProduct.BOOK){
                            product = (Book) product;
                            System.out.println(product.displayProductInfo());
                        }
                        else if(productController.checkType(product) == ClassOfProduct.CIGAR){
                            product = (Cigar) product;
                            System.out.println(product.displayProductInfo());
                        }
                        break;
                    case 4:
                        productController.display(myProducts);
                        break;
                    case 5:
                        System.out.println("Enter id");
                        sc.nextLine();
                        String id = sc.nextLine();
                        ClassOfProduct checkType = productController.checkType(productController.find(myProducts,id));
                        Product newProduct = productController.factoryProduct(checkType);
                        productController.update(myProducts,newProduct,Integer.parseInt(id));
                        productController.display(myProducts);
                        productRepository.save(myProducts);
                        break;
                    case 6:
                        addNewProduct();
                    case 0:
                        productRepository.save(myProducts);
                        System.exit(0);
                    default:
                        System.out.println("Enter your choice again!");
                }
            }
        }


    }

    public void addNewProduct() {
        while (true) {
            System.out.println("Which type of Product do you want to add?");
            System.out.println("0. Back");
            System.out.println("1.Book");
            System.out.println("2.Cigar");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    productController.add(myProducts, productController.factoryProduct(ClassOfProduct.BOOK));
                    productRepository.save(myProducts);
                    break;
                case 2:
                    productController.add(myProducts, productController.factoryProduct(ClassOfProduct.CIGAR));
                    productRepository.save(myProducts);
                    break;
                case 3:
                    System.exit(0);
                case 0:
                    staffMenu();
                default:
                    System.out.println("Enter 0 or 1 or 2");
            }
        }
    }



}
