package se.denize.examensarbete.authorities;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import se.denize.examensarbete.authorities.UserPermissions;

import java.util.ArrayList;
import java.util.List;

import static se.denize.examensarbete.authorities.UserPermissions.*;

public enum UserRoles {

    USER(List.of(USER_READ)),
    ADMIN(List.of(ADMIN_READ, ADMIN_WRITE));

    private final List<UserPermissions> permissions;

    UserRoles(List<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public List<UserPermissions> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> permissions = new
                ArrayList<>(getPermissions().stream().map(
                index -> new SimpleGrantedAuthority(index.getPermission())
        ).toList());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
