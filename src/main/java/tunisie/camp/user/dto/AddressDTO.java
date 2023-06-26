package tunisie.camp.user.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class AddressDTO {
    private UUID id;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String country;
}
