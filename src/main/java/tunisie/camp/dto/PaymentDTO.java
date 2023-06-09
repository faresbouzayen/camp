package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PaymentDTO {
    private long id;
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
