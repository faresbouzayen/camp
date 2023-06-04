package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Reclamation;
import tunisie.camp.repository.ReclamationRepository;

import java.util.NoSuchElementException;

@Service
public class ReclamationService {
private final ReclamationRepository reclamation_repository;
@Autowired
    public ReclamationService (ReclamationRepository reclamation_repository){
    this.reclamation_repository = reclamation_repository;
}
public Iterable<Reclamation> findAllReclamations(){
    return reclamation_repository.findAll();
}
public Reclamation findReclamationById(long reclamation_id){
    return findOrThrow(reclamation_id);
}
public Reclamation findOrThrow(final long reclamation_id){
    return reclamation_repository
            .findById(reclamation_id)
            .orElseThrow(
                    ()-> new NoSuchElementException(("No reclamation was found by this id " + reclamation_id))
            );

}
public Reclamation addReclamation(Reclamation reclamation){
    return reclamation_repository.save(reclamation);
}
public void updateReclamation(long reclamation_id, Reclamation reclamation){
    findReclamationById(reclamation_id);
    reclamation_repository.save(reclamation);
}
public void removeReclamation(long reclamation_id){
    reclamation_repository.deleteById(reclamation_id);
}

}
