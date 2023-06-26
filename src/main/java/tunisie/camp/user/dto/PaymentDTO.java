package tunisie.camp.user.dto;

import lombok.*;
import tunisie.camp.user.domain.*;

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
