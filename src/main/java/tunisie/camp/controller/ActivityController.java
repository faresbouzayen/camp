package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Activity;
import tunisie.camp.dto.ActivityDTO;
import tunisie.camp.service.ActivityService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/activities")
public class ActivityController {
    private final ActivityService activity_service;
    private final ModelMapper not_mapper;

    private ActivityDTO toDto(Activity activity){
        return not_mapper.map(activity, ActivityDTO.class);
    }
    private Activity toEntity(ActivityDTO activityDTO){
        return not_mapper.map(activityDTO, Activity.class);
    }

    @GetMapping
    public List<ActivityDTO> getActivitys(){
        var activity_list = StreamSupport
                .stream(activity_service.findAllActivitys().spliterator(), false)
                .collect(Collectors.toList());
        return activity_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ActivityDTO postActivity(@Validated @RequestBody ActivityDTO activity_dto){
        var entity = toEntity(activity_dto);
        var activity = activity_service.addActivity(entity);
        return toDto(activity);
    }

    @PutMapping("/{activity_id}")
    public void putActivity(@PathVariable("activity_id") UUID activity_id, @Validated @RequestBody ActivityDTO activity_dto){
        var activity_domain = toEntity(activity_dto);
        activity_service.updateActivity(activity_id,activity_domain);
    }

    @DeleteMapping("/{activity_id}")
    public void deleteActivityById(@PathVariable("activity_id") UUID activity_id){
        activity_service.removeActivity(activity_id);
    }
}
