package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Campsite;

import java.util.UUID;
@Repository
@RepositoryRestResource(path="campsites")
public interface CampsiteRepository extends CrudRepository<Campsite, UUID> {
}
