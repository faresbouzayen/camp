package tunisie.camp.domain;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long address_id;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String country;
}
