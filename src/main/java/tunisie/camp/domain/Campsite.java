package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "Campsite")
    private Weather weather;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "campsite_activity", joinColumns = @JoinColumn(name = "campsite_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private Set<Activity> activities;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "campsite_user", joinColumns = @JoinColumn(name = "campsite_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    @OneToOne(mappedBy = "Campsite")
    private Payment payment;

    @OneToMany(mappedBy = "campsite")
    private Set<Transport> transports;
}
