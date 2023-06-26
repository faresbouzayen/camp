package tunisie.camp.user.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.user.domain.Payment;
import tunisie.camp.user.dto.PaymentDTO;
import tunisie.camp.user.services.PaymentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class PaymentController {
    private final PaymentService payment_service;
    private final ModelMapper not_mapper;

    private PaymentDTO toDto(Payment payment){
        return not_mapper.map(payment, PaymentDTO.class);
    }
    private Payment toEntity(PaymentDTO paymentDTO){
        return not_mapper.map(paymentDTO, Payment.class);
    }

    @GetMapping("/payments")
    public List<PaymentDTO> getPayments(){
        var payment_list = StreamSupport
                .stream(payment_service.findAllPayments().spliterator(), false)
                .collect(Collectors.toList());
        return payment_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/payments")
    public PaymentDTO postPayment(@Validated @RequestBody PaymentDTO payment_dto){
        var entity = toEntity(payment_dto);
        var payment = payment_service.addPayment(entity);
        return toDto(payment);
    }

    @PutMapping("/payments/{id}")
    public void putPayment(@PathVariable("id") UUID id, @Validated @RequestBody PaymentDTO payment_dto){
        var payment_domain = toEntity(payment_dto);
        payment_service.updatePayment(id,payment_domain);
    }

    @DeleteMapping("/payments/{id}")
    public void deletePaymentById(@PathVariable("id") UUID id){
        payment_service.removePayment(id);
    }
}
