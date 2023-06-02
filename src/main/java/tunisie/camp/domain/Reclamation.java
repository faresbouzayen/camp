package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
