package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payment_id;
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
