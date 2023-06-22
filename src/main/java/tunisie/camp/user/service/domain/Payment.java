package tunisie.camp.user.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@RedisHash
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;
    private double paymentAmount;
    private Date paymentDate;
    private Status transacttionStatus;
    private Method paymentMethod;
    private String payerName;
    private String receiptUrl;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pro_id")
    private Product product;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "add_id")
    private Address address;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "camp_id")
    private Campsite campsite;

}
