package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.User;

import java.util.UUID;
@Repository
@RepositoryRestResource(path="users")
public interface UserRepository extends CrudRepository<User, UUID> {
}
