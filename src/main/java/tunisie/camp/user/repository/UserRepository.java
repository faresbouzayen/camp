package tunisie.camp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tunisie.camp.user.domain.User;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(
            "SELECT CASE WHEN COUNT(u) > 0 THEN " +
                    "TRUE ELSE FALSE END " +
                    "FROM User u " +
                    "WHERE u.email = ?1"
    )
    Boolean selectExistsEmail(String email);
    User findByEmail(String email);
}
