package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Campsite;
import tunisie.camp.repository.CampsiteRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CampsiteService {
    private CampsiteRepository campsite_repository;
    @Autowired
    public CampsiteService(CampsiteRepository campsite_repository){
        this.campsite_repository = campsite_repository;
    }

    public Campsite findOrThrow(final UUID id){
        return campsite_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Campsite> findAllCampsites(){
        return campsite_repository.findAll();
    }
    public Campsite findCampsiteById(UUID id){
        return findOrThrow(id);
    }
    public void removeCampsite(UUID id){
        campsite_repository.deleteById(id);
    }
    public Campsite addCampsite(Campsite campsite){
        return campsite_repository.save(campsite);
    }
    public void updateCampsite(UUID id, Campsite campsite){
        findCampsiteById(id);
        campsite_repository.save(campsite);
    }
}
