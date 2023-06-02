package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID product_id;
    private String productName;
    private String productType;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private boolean productAvailability;
    private double productPromotion;
    private Equipment equipmentType;
}