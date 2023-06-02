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
    public void updateUser(UUID user_id, User user){
        findOrThrow(user_id);
        user_repository.save(user);
    }
    public Iterable<User> findAllUsers(){
        return user_repository.findAll();
    }
    public User findUserById(UUID user_id){
        return findOrThrow(user_id);
    }
    public void removeUserById(UUID user_id){
        user_repository.deleteById(user_id);
    }
    public User findOrThrow(final UUID user_id){
        return user_repository
                .findById(user_id)
                .orElseThrow(
                        () -> new NoSuchElementException("No User " + user_id + "was found" )
                );
    }
}
