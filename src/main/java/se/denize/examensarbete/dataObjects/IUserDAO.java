package se.denize.examensarbete.dataObjects;

import org.springframework.security.core.userdetails.UserDetails;
import se.denize.examensarbete.model.User;

import java.util.Collection;
import java.util.Optional;

public interface IUserDAO<T> {

    Collection<User> findAllUsers();
    User save(User user);

    void deleteById(long userId);

    Optional<User> findById(long userId);

    UserDetails loadUserByUsername(String username);

    User findOtherParent(long userId);
}
