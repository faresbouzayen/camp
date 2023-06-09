package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.HashSet;
import java.util.UUID;
import java.util.Set;
@RedisHash

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private Role userRole;

    @ManyToMany(mappedBy = "users")
    private Set<Forum> forums = new HashSet<Forum>();

    @ManyToMany(mappedBy = "users")
    private Set<Product> products = new HashSet<Product>();

    @ManyToMany(mappedBy = "users")
    private Set<Reclamation> reclamations = new HashSet<Reclamation>();

    @ManyToMany(mappedBy = "users")
    private Set<Campsite> campsites = new HashSet<Campsite>();
}
