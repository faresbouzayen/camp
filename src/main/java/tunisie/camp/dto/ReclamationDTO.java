package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.TypeReclamation;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class ReclamationDTO {
    private UUID id;
    private String reclamationName;
    private TypeReclamation reclamationNote;
    private String description;
    private Date dateofreclamation;
    private Date resolutionDate;
    private String response;
}
