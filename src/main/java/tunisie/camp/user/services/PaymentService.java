package tunisie.camp.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.domain.Payment;
import tunisie.camp.user.repository.PaymentRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PaymentService {
    private PaymentRepository payment_repository;
    @Autowired
    public PaymentService(PaymentRepository payment_repository){
        this.payment_repository = payment_repository;
    }

    public Payment findOrThrow(final UUID id){
        return payment_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Payment> findAllPayments(){
        return payment_repository.findAll();
    }
    public Payment findPaymentById(UUID id){
        return findOrThrow(id);
    }
    public void removePayment(UUID id){
        payment_repository.deleteById(id);
    }
    public Payment addPayment(Payment payment){
        return payment_repository.save(payment);
    }
    public void updatePayment(UUID id, Payment payment){
        findPaymentById(id);
        payment_repository.save(payment);
    }
}
