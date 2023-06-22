package tunisie.camp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.service.domain.Activity;
import tunisie.camp.user.service.repository.ActivityRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ActivityService {
    private ActivityRepository activity_repository;
    @Autowired
    public ActivityService(ActivityRepository activity_repository){
        this.activity_repository = activity_repository;
    }

    public Activity findOrThrow(final UUID id){
        return activity_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Activity> findAllActivitys(){
        return activity_repository.findAll();
    }
    public Activity findActivityById(UUID id){
        return findOrThrow(id);
    }
    public void removeActivity(UUID id){
        activity_repository.deleteById(id);
    }
    public Activity addActivity(Activity activity){
        return activity_repository.save(activity);
    }
    public void updateActivity(UUID id, Activity activity){
        findActivityById(id);
        activity_repository.save(activity);
    }
}
