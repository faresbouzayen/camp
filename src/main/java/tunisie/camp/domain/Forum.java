package tunisie.camp.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID forum_id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;
    private User participants;

}
