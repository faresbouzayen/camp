package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.Campsite;
import tunisie.camp.user.service.domain.Difficulty;

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
