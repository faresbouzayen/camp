package tunisie.camp.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.user.dto.UserDTO;
import tunisie.camp.user.services.UserService;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public Iterable<UserDTO> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/api/v1/users/{id}")
    public UserDTO getUserById(@PathVariable("id") UUID id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/api/v1/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.removeUserById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser(@Valid @RequestBody UserDTO userDto)
            throws NoSuchAlgorithmException {
        return userService.createUser(userDto,
                userDto.getPassword());
    }

    @PutMapping("/api/v1/users/{id}")
    public void putUser(
            @PathVariable("id") UUID id,
            @Valid @RequestBody UserDTO userDto
    ) throws NoSuchAlgorithmException {
        userService.updateUser(id, userDto,
                userDto.getPassword());
    }
}