package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.Campsite;
import tunisie.camp.user.service.domain.Transportation;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TransportDTO {
    private UUID id;
    private Transportation transportType;
    private String departureLocation;
    private String DestinationLocation;
    private Date departureTime;
    private Date arrivalTime;
    private Campsite camspiteDestinations;
    private double ticketPrice;
    private String OperatorName;
    private Date travelDuration;

}
