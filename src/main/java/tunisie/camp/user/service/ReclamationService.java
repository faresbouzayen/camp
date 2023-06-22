package tunisie.camp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.service.domain.Reclamation;
import tunisie.camp.user.service.repository.ReclamationRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

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
public Reclamation findReclamationById(UUID id){
    return findOrThrow(id);
}
public Reclamation findOrThrow(final UUID id){
    return reclamation_repository
            .findById(id)
            .orElseThrow(
                    ()-> new NoSuchElementException(("No reclamation was found by this id " + id))
            );

}
public Reclamation addReclamation(Reclamation reclamation){
    return reclamation_repository.save(reclamation);
}
public void updateReclamation(UUID id, Reclamation reclamation){
    findReclamationById(id);
    reclamation_repository.save(reclamation);
}
public void removeReclamation(UUID id){
    reclamation_repository.deleteById(id);
}

}
