package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity

public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transport_id;
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
