package tunisie.camp.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.camp.domain.Forum;
import tunisie.camp.camp.dto.ForumDTO;
import tunisie.camp.camp.services.ForumService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class ForumController {
    private final ForumService forum_service;
    private final ModelMapper not_mapper;

    private ForumDTO toDto(Forum forum){
        return not_mapper.map(forum, ForumDTO.class);
    }
    private Forum toEntity(ForumDTO forumDTO){
        return not_mapper.map(forumDTO, Forum.class);
    }

    @GetMapping("/forums")
    public List<ForumDTO> getForums(){
        var forum_list = StreamSupport
                .stream(forum_service.findAllForums().spliterator(), false)
                .collect(Collectors.toList());
        return forum_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/forums")
    public ForumDTO postForum(@Validated @RequestBody ForumDTO forum_dto){
        var entity = toEntity(forum_dto);
        var forum = forum_service.addForum(entity);
        return toDto(forum);
    }

    @PutMapping("/forums/{id}")
    public void putForum(@PathVariable("id") UUID id, @Validated @RequestBody ForumDTO forum_dto){
        var forum_domain = toEntity(forum_dto);
        forum_service.updateForum(id,forum_domain);
    }

    @DeleteMapping("/forums/{id}")
    public void deleteForumById(@PathVariable("id") UUID id){
        forum_service.removeForum(id);
    }
}
