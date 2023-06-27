package tunisie.camp.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.camp.domain.Transport;

import java.util.UUID;
@Repository
public interface TransportRepository extends CrudRepository<Transport, UUID> {
}
