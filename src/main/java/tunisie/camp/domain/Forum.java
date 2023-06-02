package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long forum_id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;
    private User participants;

}
