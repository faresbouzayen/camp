package tunisie.camp.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.user.domain.Address;

import java.util.UUID;
@Repository
public interface AddressRepository extends CrudRepository<Address, UUID> {
}
