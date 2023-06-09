package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.User;
import tunisie.camp.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository user_repository;
    @Autowired
    public UserService(UserRepository user_repository){
        this.user_repository = user_repository;
    }
    public User addUser(User user){
        return user_repository.save(user);
    }
    public void updateUser(UUID id, User user){
        findOrThrow(id);
        user_repository.save(user);
    }
    public Iterable<User> findAllUsers(){
        return user_repository.findAll();
    }
    public User findUserById(UUID id){
        return findOrThrow(id);
    }
    public void removeUserById(UUID id){
        user_repository.deleteById(id);
    }
    public User findOrThrow(final UUID id){
        return user_repository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("No User " + id + "was found" )
                );
    }
}
