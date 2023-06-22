package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class PaymentDTO {
    private UUID id;
    private double paymentAmount;
    private Date paymentDate;
    private Product productInfo;
    private Campsite campsiteInfo;
    private Status transacttionStatus;
    private Method paymentMethod;
    private String payerName;
    private Address billingAdress;
    private String receiptUrl;
}
