package se.denize.examensarbete.authorities;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import se.denize.examensarbete.authorities.UserPermissions;

import java.util.ArrayList;
import java.util.List;

import static se.denize.examensarbete.authorities.UserPermissions.*;

public enum UserRoles {

    //TODO: if not working check out spring boot login that I made before..
    USER(List.of(USER_READ)),
    ADMIN(List.of(ADMIN_READ, ADMIN_WRITE));

    private final List<UserPermissions> permissions;

    UserRoles(List<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public List<UserPermissions> getPermissions() {
        return permissions;
    }

    public List<String> getGrantedAuthorities() {
        List<String> permissionList = new
                ArrayList<>(getPermissions().stream().map(
   UserPermissions::getPermission).toList());
        permissionList.add(("ROLE_" + this.name()));
        return permissionList;
    }

}
