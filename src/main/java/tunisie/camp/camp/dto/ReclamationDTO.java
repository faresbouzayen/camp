package tunisie.camp.camp.dto;

import lombok.*;
import tunisie.camp.camp.domain.TypeReclamation;

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
