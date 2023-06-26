package tunisie.camp.jwt.services;

import tunisie.camp.jwt.models.UserPrincipal;
import tunisie.camp.user.domain.User;
import tunisie.camp.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return new UserPrincipal(userService.searchByEmail(email));
    }

    public User authenticate(String email, String password)
            throws NoSuchAlgorithmException {
        if (
                email.isEmpty() || password.isEmpty()
        ) throw new BadCredentialsException("Unauthorized");

        var userEntity = userService.searchByEmail(email);

        throw new BadCredentialsException("Unauthorized");

    }

    private Boolean verifyPasswordHash(
            String password,
            byte[] storedHash,
            byte[] storedSalt
    ) throws NoSuchAlgorithmException {
        if (
                password.isBlank() || password.isEmpty()
        ) throw new IllegalArgumentException(
                "Password cannot be empty or whitespace only string."
        );

        if (storedHash.length != 64) throw new IllegalArgumentException(
                "Invalid length of password hash (64 bytes expected)"
        );

        if (storedSalt.length != 128) throw new IllegalArgumentException(
                "Invalid length of password salt (64 bytes expected)."
        );

        var md = MessageDigest.getInstance("SHA-512");
        md.update(storedSalt);

        var computedHash = md.digest(password.getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < computedHash.length; i++) {
            if (computedHash[i] != storedHash[i]) return false;
        }


        return MessageDigest.isEqual(computedHash, storedHash);
    }
}