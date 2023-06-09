package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.User;
import tunisie.camp.dto.UserDTO;
import tunisie.camp.service.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService user_service;
    private final ModelMapper not_mapper;

    private UserDTO toDto(User user){
        return not_mapper.map(user, UserDTO.class);
    }
    private User toEntity(UserDTO userDTO){
        return not_mapper.map(userDTO, User.class);
    }

    @GetMapping
    public List<UserDTO> getUsers(){
        var user_list = StreamSupport
                .stream(user_service.findAllUsers().spliterator(), false)
                .collect(Collectors.toList());
        return user_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserDTO postUser(@Validated @RequestBody UserDTO user_dto){
        var entity = toEntity(user_dto);
        var user = user_service.addUser(entity);
        return toDto(user);
    }

    @PutMapping("/{id}")
    public void putUser(@PathVariable("id") UUID id, @Validated @RequestBody UserDTO user_dto){
        var user_domain = toEntity(user_dto);
        user_service.updateUser(id,user_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        user_service.removeUserById(id);
    }
}
