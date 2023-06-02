package tunisie.camp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Campsite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID campsite_id;
    private String campsiteName;
    private String campsiteLocation;
    private String campsiteCapacity;
    private String campsiteAddress;
    private Date availableCampsiteDates;
}
