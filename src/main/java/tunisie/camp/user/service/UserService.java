package tunisie.camp.user.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tunisie.camp.user.service.domain.User;
import tunisie.camp.user.service.dto.UserDTO;
import tunisie.camp.user.service.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository user_repository;
    @Autowired
    public UserService(UserRepository user_repository){
        this.user_repository = user_repository;
    }
    @Autowired
    private ModelMapper modelMapper;
    private UserDTO convertToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
    private User convertToEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public List<UserDTO> findAllUsers() {
        var userEntityList =
                new ArrayList<>(user_repository.findAll());
        return userEntityList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO findUserById(final UUID id) {
        var user = user_repository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User by id " + id +
                                " was not found")
                );
        return convertToDto(user);
    }

    private byte[] createSalt() {
        var random = new SecureRandom();
        var salt = new byte[128];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] createPasswordHash(String password, byte[] salt)
            throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        return md.digest(
                password.getBytes(StandardCharsets.UTF_8));
    }

    public UserDTO createUser(UserDTO userDto, String password)
            throws NoSuchAlgorithmException {
        var user = convertToEntity(userDto);
        if (password.isBlank()) throw new
                IllegalArgumentException(
                "Password is required."
        );

        byte[] salt = createSalt();
        byte[] hashedPassword =
                createPasswordHash(password, salt);
        user.setStoredSalt(salt);
        user.setStoredHash(hashedPassword);
        user_repository.save(user);
        return convertToDto(user);
    }

    public void updateUser(UUID id, UserDTO userDto, String password)
            throws NoSuchAlgorithmException {
        var user = findOrThrow(id);
        var userParam = convertToEntity(userDto);
        user.setEmail(userParam.getEmail());
        user.setMobileNumber(userParam.getMobileNumber());
        if (!password.isBlank()) {
            byte[] salt = createSalt();
            byte[] hashedPassword =
                    createPasswordHash(password, salt);
            user.setStoredSalt(salt);
            user.setStoredHash(hashedPassword);
        }
        user_repository.save(user);
    }
    public void removeUserById(UUID id) {
        findOrThrow(id);
        user_repository.deleteById(id);
    }
    private User findOrThrow(final UUID id) {
        return user_repository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User by id " + id +
                                " was not found")
                );
    }

}
