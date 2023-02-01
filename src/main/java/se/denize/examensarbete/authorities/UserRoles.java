package se.denize.examensarbete.authorities;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import se.denize.examensarbete.authorities.UserPermissions;

import java.util.ArrayList;
import java.util.List;

import static se.denize.examensarbete.authorities.UserPermissions.*;

public enum UserRoles {


    ADMIN,
    USER;

}
