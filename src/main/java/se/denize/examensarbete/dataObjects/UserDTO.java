package se.denize.examensarbete.dataObjects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.denize.examensarbete.model.User;

import java.util.Collection;

public class UserDTO {
    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;


    public UserDTO(User user) {
        this.username = user.getUsername();
        this.authorities = user.getAuthorities();
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
