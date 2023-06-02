package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.TypeReclamation;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class ReclamationDTO {
    private long reclamation_id;
    private String reclamationName;
    private TypeReclamation reclamationNote;
    private String description;
    private Date dateofreclamation;
    private Date resolutionDate;
    private String response;
}
