package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Campsite;

import java.util.UUID;
@Repository
public interface CampsiteRepository extends CrudRepository<Campsite, UUID> {
}
