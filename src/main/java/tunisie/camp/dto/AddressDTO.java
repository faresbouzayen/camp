package tunisie.camp.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
public class AddressDTO {
    private long address_id;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String country;
}
