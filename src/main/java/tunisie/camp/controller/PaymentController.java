package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Payment;
import tunisie.camp.dto.PaymentDTO;
import tunisie.camp.service.PaymentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @GetMapping
    public List<PaymentDTO> getPayments(){
        var payment_list = StreamSupport
                .stream(payment_service.findAllPayments().spliterator(), false)
                .collect(Collectors.toList());
        return payment_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PaymentDTO postPayment(@Validated @RequestBody PaymentDTO payment_dto){
        var entity = toEntity(payment_dto);
        var payment = payment_service.addPayment(entity);
        return toDto(payment);
    }

    @PutMapping("/{id}")
    public void putPayment(@PathVariable("id") UUID id, @Validated @RequestBody PaymentDTO payment_dto){
        var payment_domain = toEntity(payment_dto);
        payment_service.updatePayment(id,payment_domain);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable("id") UUID id){
        payment_service.removePayment(id);
    }
}
