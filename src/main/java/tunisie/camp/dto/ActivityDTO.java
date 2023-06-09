package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Campsite;
import tunisie.camp.domain.Difficulty;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ActivityDTO {
    private UUID id;
    private String activityName;
    private String description;
    private int duration;
    private Difficulty difficultyLevel;
    private Campsite campsiteCount;
    private Date startDate;
    private Date endDate;
    private String equipementRequired;

}
