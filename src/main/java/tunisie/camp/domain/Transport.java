package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RedisHash
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private Transportation transportType;
    private String departureLocation;
    private String DestinationLocation;
    private Date departureTime;
    private Date arrivalTime;
    private double ticketPrice;
    private String OperatorName;
    private Date travelDuration;

    @ManyToMany(mappedBy = "transports")
    private Set<Campsite> campsites = new HashSet<Campsite>();
}
