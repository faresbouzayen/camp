package tunisie.camp.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.camp.domain.Activity;
import tunisie.camp.camp.dto.ActivityDTO;
import tunisie.camp.camp.services.ActivityService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class ActivityController {
    private final ActivityService activity_service;
    private final ModelMapper not_mapper;

    private ActivityDTO toDto(Activity activity){
        return not_mapper.map(activity, ActivityDTO.class);
    }
    private Activity toEntity(ActivityDTO activityDTO){
        return not_mapper.map(activityDTO, Activity.class);
    }

    @GetMapping("/activities")
    public List<ActivityDTO> getActivities(){
        var activity_list = StreamSupport
                .stream(activity_service.findAllActivitys().spliterator(), false)
                .collect(Collectors.toList());
        return activity_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/activities")
    public ActivityDTO postActivity(@Validated @RequestBody ActivityDTO activity_dto){
        var entity = toEntity(activity_dto);
        var activity = activity_service.addActivity(entity);
        return toDto(activity);
    }

    @PutMapping("/activities/{id}")
    public void putActivity(@PathVariable("id") UUID id, @Validated @RequestBody ActivityDTO activity_dto){
        var activity_domain = toEntity(activity_dto);
        activity_service.updateActivity(id,activity_domain);
    }

    @DeleteMapping("activities/{id}")
    public void deleteActivityById(@PathVariable("id") UUID id){
        activity_service.removeActivity(id);
    }
}
