package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Activity;

import java.util.UUID;
@Repository
@RepositoryRestResource(path="activities")
public interface ActivityRepository extends CrudRepository<Activity, UUID> {
}
