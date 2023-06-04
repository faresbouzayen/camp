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

    public Campsite findOrThrow(final UUID campsite_id){
        return campsite_repository
                .findById(campsite_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + campsite_id)
                );
    }
    public Iterable<Campsite> findAllCampsites(){
        return campsite_repository.findAll();
    }
    public Campsite findCampsiteById(UUID campsite_id){
        return findOrThrow(campsite_id);
    }
    public void removeCampsite(UUID campsite_id){
        campsite_repository.deleteById(campsite_id);
    }
    public Campsite addCampsite(Campsite campsite){
        return campsite_repository.save(campsite);
    }
    public void updateCampsite(UUID campsite_id, Campsite campsite){
        findCampsiteById(campsite_id);
        campsite_repository.save(campsite);
    }
}
