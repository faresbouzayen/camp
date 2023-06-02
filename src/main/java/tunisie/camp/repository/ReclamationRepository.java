package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Reclamation;

import java.util.UUID;
@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
}
