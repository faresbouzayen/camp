package tunisie.camp.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID user_id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private Role userRole;
}
