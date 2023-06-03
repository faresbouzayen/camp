package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Campsite campsite;
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Product product;
}
