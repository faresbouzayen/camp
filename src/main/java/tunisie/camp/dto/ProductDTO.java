package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Equipment;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
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
