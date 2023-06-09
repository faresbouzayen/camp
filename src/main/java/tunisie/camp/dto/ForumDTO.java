package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Feedback;
import tunisie.camp.domain.User;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
public class ForumDTO {
    private UUID id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;
    private User participants;

}
