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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/payments")
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

    @PutMapping("/{payment_id}")
    public void putPayment(@PathVariable("payment_id") long payment_id, @Validated @RequestBody PaymentDTO payment_dto){
        if (payment_id != payment_dto.getPayment_id()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"payment id not found");
        var payment_domain = toEntity(payment_dto);
        payment_service.updatePayment(payment_id,payment_domain);
    }

    @DeleteMapping("/{payment_id}")
    public void deletePaymentById(@PathVariable("payment_id") long payment_id){
        payment_service.removePayment(payment_id);
    }
}
