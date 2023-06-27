package tunisie.camp.camp.dto;

import lombok.*;
import tunisie.camp.camp.domain.Feedback;
import tunisie.camp.user.entity.UserEntity;

import java.util.UUID;

@Getter
@Setter
public class ForumDTO {
    private UUID id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;
    private UserEntity participants;

}
