package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Status transacttionStatus;
    private Method paymentMethod;
    private String payerName;
    private String receiptUrl;


}
