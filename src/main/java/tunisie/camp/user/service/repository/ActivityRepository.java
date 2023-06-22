package tunisie.camp.user.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.user.service.domain.Activity;

import java.util.UUID;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, UUID> {
}