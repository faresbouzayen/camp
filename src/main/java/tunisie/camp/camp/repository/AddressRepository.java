package tunisie.camp.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.camp.domain.Address;

import java.util.UUID;
@Repository
public interface AddressRepository extends CrudRepository<Address, UUID> {
}
