package service.impl;

import model.concrete.Book;
import model.Product;
import org.junit.jupiter.api.Test;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    void findTest1() {
        List<Product> books = new ArrayList<>();
        books.add(new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
        books.add(new Book("Công chúa  bé",1112,"Tuan Lee",3000,"Fiction"));
        books.add(new Book("Anh chúa  bé",1113,"Tuan Lee",1000,"Fiction"));
        ProductService productService = new ProductServiceImpl();
        String  productExpected = "Hoàng tử bé";
        String check = productService.find(books,"1111").getName();
        assertEquals(productExpected,check);
    }
    @Test
    void findTest2() {
        List<Product> books = new ArrayList<>();
        books.add(new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
        books.add(new Book("Công chúa  bé",1112,"Tuan Lee",3000,"Fiction"));
        books.add(new Book("Anh chúa  bé",1113,"Tuan Lee",1000,"Fiction"));
        ProductService productService = new ProductServiceImpl();
        int  productExpected = Integer.parseInt("1112");
        Integer check = productService.find(books,"1112").getId();
        assertEquals(productExpected,check);
    }
    @Test
    void findTest3() {
        List<Product> books = new ArrayList<>();
        books.add(new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
        books.add(new Book("Công chúa  bé",1112,"Tuan Lee",3000,"Fiction"));
        books.add(new Book("Anh cu bé",1113,"Tuan Lee",1000,"Fiction"));
        ProductService productService = new ProductServiceImpl();
        String  productExpected = "Tuan Lee";
        String check = ((Book)productService.find(books,"Anh cu bé")).getAuthor();
        assertEquals(productExpected,check);
    }

    @Test
    void addTest() {
        List<Product> books = new ArrayList<>();
        books.add(new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
        books.add(new Book("Công chúa  bé",1112,"Tuan Lee",3000,"Fiction"));
        books.add(new Book("Anh cu bé",1113,"Tuan Lee",1000,"Fiction"));
        ProductService productService = new ProductServiceImpl();
        productService.add(books,new Book("Anh bé",1114,"Tuan Lee",1000,"Fiction"));
        String  book = books.get(3).getName();
        String bookExpected = "Anh bé";
        assertEquals(book,bookExpected);
    }
}