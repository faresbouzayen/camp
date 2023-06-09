package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Product;

import java.util.UUID;
@Repository
@RepositoryRestResource(path="products")
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
