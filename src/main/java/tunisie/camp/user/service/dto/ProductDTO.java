package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.Equipment;

import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private UUID id;
    private String productName;
    private String productType;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private boolean productAvailability;
    private double productPromotion;
    private Equipment equipmentType;
}
