package tunisie.camp.user.domain;

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
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String activityName;
    private String description;
    private int duration;
    private Difficulty difficultyLevel;
    private Date startDate;
    private Date endDate;
    private String equipementRequired;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "activity_campsite",
    joinColumns = {@JoinColumn(name = "activity_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Campsite> campsites = new HashSet<Campsite>();

    }
