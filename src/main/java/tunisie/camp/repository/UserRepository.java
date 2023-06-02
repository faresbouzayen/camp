package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.User;

import java.util.UUID;
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
