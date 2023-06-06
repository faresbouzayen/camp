package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Payment;

import java.util.UUID;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
