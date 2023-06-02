package tunisie.camp.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID activity_id;
    private String activityName;
    private String description;
    private int duration;
    private Difficulty difficultyLevel;
    private Campsite campsiteCount;
    private Date startDate;
    private Date endDate;
    private String equipementRequired;

}
