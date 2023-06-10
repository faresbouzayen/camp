package tunisie.camp.dto;

import lombok.*;

import javax.persistence.*;
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
