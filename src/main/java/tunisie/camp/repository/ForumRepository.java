package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Forum;

import java.util.UUID;
@Repository
public interface ForumRepository extends CrudRepository<Forum, UUID> {
}
