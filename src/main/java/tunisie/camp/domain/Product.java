package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@RedisHash
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String productName;
    private String productType;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private boolean productAvailability;
    private double productPromotion;
    private Equipment equipmentType;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_user",
    joinColumns = {@JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<User> users = new HashSet<User>();

    @OneToOne(mappedBy = "product")
    private Payment payment;

}
