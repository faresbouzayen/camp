package tunisie.camp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long reclamation_id;
    private String reclamationName;
    private TypeReclamation reclamationNote;
    private String description;
    private Date dateofreclamation;
    private Date resolutionDate;
    private String response;
}
