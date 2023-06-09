package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Role;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private Role userRole;
}
