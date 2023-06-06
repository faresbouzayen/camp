package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Payment;
import tunisie.camp.repository.PaymentRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PaymentService {
    private PaymentRepository payment_repository;
    @Autowired
    public PaymentService(PaymentRepository payment_repository){
        this.payment_repository = payment_repository;
    }

    public Payment findOrThrow(final Long payment_id){
        return payment_repository
                .findById(payment_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + payment_id)
                );
    }
    public Iterable<Payment> findAllPayments(){
        return payment_repository.findAll();
    }
    public Payment findPaymentById(Long payment_id){
        return findOrThrow(payment_id);
    }
    public void removePayment(long payment_id){
        payment_repository.deleteById(payment_id);
    }
    public Payment addPayment(Payment payment){
        return payment_repository.save(payment);
    }
    public void updatePayment(Long payment_id, Payment payment){
        findPaymentById(payment_id);
        payment_repository.save(payment);
    }
}
