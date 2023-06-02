package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Campsite;
import tunisie.camp.domain.Transportation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TransportDTO {
    private UUID transport_id;
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
