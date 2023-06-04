package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Product;
import tunisie.camp.repository.ProductRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository product_repository;
    @Autowired
    public ProductService(ProductRepository product_repository){
        this.product_repository = product_repository;
    }

    public Product findOrThrow(final UUID product_id){
        return product_repository
                .findById(product_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + product_id)
                );
    }
    public Iterable<Product> findAllProducts(){
        return product_repository.findAll();
    }
    public Product findProductById(UUID product_id){
        return findOrThrow(product_id);
    }
    public void removeProduct(UUID product_id){
        product_repository.deleteById(product_id);
    }
    public Product addProduct(Product product){
        return product_repository.save(product);
    }
    public void updateProduct(UUID product_id, Product product){
        findProductById(product_id);
        product_repository.save(product);
    }
}
