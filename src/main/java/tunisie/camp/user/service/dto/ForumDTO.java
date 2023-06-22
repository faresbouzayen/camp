package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.Feedback;
import tunisie.camp.user.service.domain.User;

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
