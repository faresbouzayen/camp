package tunisie.camp.user.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@RedisHash
public class Campsite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String campsiteName;
    private String campsiteLocation;
    private String campsiteCapacity;
    private String campsiteAddress;
    private Date availableCampsiteDates;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "campsite_user",
    joinColumns = {@JoinColumn(name = "campsite_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<User> users = new HashSet<User>();

    @ManyToMany(mappedBy = "campsites")
    private Set<Activity> activities = new HashSet<Activity>();

    @OneToOne(mappedBy = "campsite")
    private Payment payment;

    @OneToOne(mappedBy = "campsite")
    private Weather weather;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "campsite_transport",
    joinColumns = {@JoinColumn(name = "campsite_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Transport> transports = new HashSet<Transport>();

}
