package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long forum_id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_forum",
    joinColumns = {@JoinColumn(name = "forum_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<User> users = new HashSet<User>();

}
