package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activity_id;
    private String activityName;
    private String description;
    private int duration;
    private Difficulty difficultyLevel;
    private Campsite campsiteCount;
    private Date startDate;
    private Date endDate;
    private String equipementRequired;

}
