package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long address_id;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String country;
}
