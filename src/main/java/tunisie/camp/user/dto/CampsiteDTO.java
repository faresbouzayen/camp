package tunisie.camp.user.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class CampsiteDTO {
    private UUID id;
    private String campsiteName;
    private String campsiteLocation;
    private String campsiteCapacity;
    private String campsiteAddress;
    private Date availableCampsiteDates;
}
