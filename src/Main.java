import model.Book;
import model.Product;
import repository.impl.ProductRepository;
import service.ProductService;
import service.impl.ProductNameComparator;
import service.impl.ProductPriceComparator;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> books = new ArrayList<>();
//        books.add(new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
//        books.add(new Book("Công chúa  bé",1112,"Tuan Lee",3000,"Fiction"));
//        books.add(new Book("Anh chúa  bé",1113,"Tuan Lee",1000,"Fiction"));
        ProductService productService = new ProductServiceImpl();

//        ProductNameComparator productNameComparator = new ProductNameComparator();
//        ProductPriceComparator productPriceComparator = new ProductPriceComparator();
//
//        productService.sort(books, productPriceComparator);
//        productService.display(books);
        ProductRepository productRepository = new ProductRepository();
//        productRepository.save(books);
        productRepository.load(books);
        books.add(new Book("Anh chúa  bé",1115,"Tuan Lee",1000,"Fiction"));
        productRepository.save(books);
    }
}
