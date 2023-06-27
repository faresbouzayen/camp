package tunisie.camp.camp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.camp.domain.Product;
import tunisie.camp.camp.repository.ProductRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository product_repository;
    @Autowired
    public ProductService(ProductRepository product_repository){
        this.product_repository = product_repository;
    }

    public Product findOrThrow(final UUID id){
        return product_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Product> findAllProducts(){
        return product_repository.findAll();
    }
    public Product findProductById(UUID id){
        return findOrThrow(id);
    }
    public void removeProduct(UUID id){
        product_repository.deleteById(id);
    }
    public Product addProduct(Product product){
        return product_repository.save(product);
    }
    public void updateProduct(UUID id, Product product){
        findProductById(id);
        product_repository.save(product);
    }
}
