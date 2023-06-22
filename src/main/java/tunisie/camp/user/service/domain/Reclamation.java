package tunisie.camp.user.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RedisHash
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String reclamationName;
    private TypeReclamation reclamationNote;
    private String description;
    private Date dateofreclamation;
    private Date resolutionDate;
    private String response;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "reclamation_user",
    joinColumns = {@JoinColumn(name = "reclamation_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<User> users = new HashSet<User>();


}
