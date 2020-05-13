import model.concrete.Book;
import model.Product;
import model.concrete.Cigar;
import repository.impl.ProductRepository;
import service.ProductService;
import service.impl.ProductNameComparator;
import service.impl.ProductPriceComparator;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductServiceImpl();
        productService.add(products,new Book("Hoàng tử bé",1111,"Tuan Lee",2000,"Fiction"));
        productService.add(products,new Book("Công chúa  bé",1111,"Tuan Lee",3000,"Fiction"));
        productService.add(products,new Book("Anh chúa  bé",1113,"Tuan Lee",1000,"Fiction"));
        productRepository.load(products);
        productService.add(products,new Cigar("44444",444,3000,"Hàng Fake",10));
        productService.display(products);


//        productRepository.save(products);
    }
}
