package se.denize.examensarbete.dataObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

@Component
public class UserDAO implements IUserDAO<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Collection<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) { return userRepository.save(user); }

    @Override
    public void deleteById(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> findById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException { return userRepository.findByUsername(username); }

    @Override
    public User findOtherParent(long userId){ return userRepository.findOtherParent(userId);}

}
