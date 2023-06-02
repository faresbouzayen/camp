package tunisie.camp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity

public class Transport {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
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
