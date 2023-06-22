package tunisie.camp.user.service.dto;

import lombok.*;
import tunisie.camp.user.service.domain.Role;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID id;
    private String email;
    private String mobileNumber;
    private String password;
}
