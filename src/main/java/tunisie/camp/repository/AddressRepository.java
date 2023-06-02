package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Address;
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
