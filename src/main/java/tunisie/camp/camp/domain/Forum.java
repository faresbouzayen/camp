package tunisie.camp.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import tunisie.camp.user.entity.UserEntity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@RedisHash
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String forumName;
    private String topic;
    private Feedback feedbackType;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_forum",
    joinColumns = {@JoinColumn(name = "forum_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<UserEntity> users = new HashSet<UserEntity>();

}
