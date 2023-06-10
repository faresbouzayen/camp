package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Transport;

import java.util.UUID;
@Repository
public interface TransportRepository extends CrudRepository<Transport, UUID> {
}
