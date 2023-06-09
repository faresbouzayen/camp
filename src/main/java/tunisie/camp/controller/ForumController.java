package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Forum;
import tunisie.camp.dto.ForumDTO;
import tunisie.camp.service.ForumService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @GetMapping
    public List<ForumDTO> getForums(){
        var forum_list = StreamSupport
                .stream(forum_service.findAllForums().spliterator(), false)
                .collect(Collectors.toList());
        return forum_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ForumDTO postForum(@Validated @RequestBody ForumDTO forum_dto){
        var entity = toEntity(forum_dto);
        var forum = forum_service.addForum(entity);
        return toDto(forum);
    }

    @PutMapping("/{id}")
    public void putForum(@PathVariable("id") UUID id, @Validated @RequestBody ForumDTO forum_dto){
        var forum_domain = toEntity(forum_dto);
        forum_service.updateForum(id,forum_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteForumById(@PathVariable("id") UUID id){
        forum_service.removeForum(id);
    }
}
