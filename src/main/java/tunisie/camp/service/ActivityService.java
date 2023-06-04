package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Activity;
import tunisie.camp.repository.ActivityRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ActivityService {
    private ActivityRepository activity_repository;
    @Autowired
    public ActivityService(ActivityRepository activity_repository){
        this.activity_repository = activity_repository;
    }

    public Activity findOrThrow(final UUID activity_id){
        return activity_repository
                .findById(activity_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + activity_id)
                );
    }
    public Iterable<Activity> findAllActivitys(){
        return activity_repository.findAll();
    }
    public Activity findActivityById(UUID activity_id){
        return findOrThrow(activity_id);
    }
    public void removeActivity(UUID activity_id){
        activity_repository.deleteById(activity_id);
    }
    public Activity addActivity(Activity activity){
        return activity_repository.save(activity);
    }
    public void updateActivity(UUID activity_id, Activity activity){
        findActivityById(activity_id);
        activity_repository.save(activity);
    }
}
