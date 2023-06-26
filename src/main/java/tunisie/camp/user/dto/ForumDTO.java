package tunisie.camp.user.dto;

import lombok.*;
import tunisie.camp.user.domain.Feedback;
import tunisie.camp.user.domain.User;

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
