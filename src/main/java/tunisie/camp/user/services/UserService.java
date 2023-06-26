package tunisie.camp.user.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tunisie.camp.user.domain.User;
import tunisie.camp.user.dto.UserDTO;
import tunisie.camp.user.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repo;
    private final ModelMapper mapper;

    public User searchByEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<UserDTO> findAllUsers() {
        var userEntityList = new ArrayList<>(repo.findAll());

        return userEntityList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDTO findUserById(final UUID id) {
        var user = repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User by id " + id + " was not found")
                );

        return convertToDto(user);
    }

    public UserDTO createUser(UserDTO userDto, String password)
            throws NoSuchAlgorithmException {
        var user = convertToEntity(userDto);

        if (password.isBlank()) throw new IllegalArgumentException(
                "Password is required"
        );

        var existsEmail = repo.selectExistsEmail(user.getEmail());
        if (existsEmail) throw new   NotFoundException(
                "Email " + user.getEmail() + " taken"
        );

        byte[] salt = createSalt();
        byte[] hashedPassword = createPasswordHash(password, salt);

        user.setStoredSalt(salt);
        user.setStoredHash(hashedPassword);

        repo.save(user);

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
            byte[] hashedPassword = createPasswordHash(password, salt);

            user.setStoredSalt(salt);
            user.setStoredHash(hashedPassword);
        }

        repo.save(user);
    }

    public void removeUserById(UUID id) {
        findOrThrow(id);
        repo.deleteById(id);
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

        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    private User findOrThrow(final UUID id) {
        return repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User by id " + id + " was not found")
                );
    }

    private UserDTO convertToDto(User entity) {
        return mapper.map(entity, UserDTO.class);
    }

    private User convertToEntity(UserDTO dto) {
        return mapper.map(dto, User.class);
    }
}