package se.denize.examensarbete;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String testAdminPermission() {
        return "only andmins can enter";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String testUserPermission() {
        return "only users can enter";
    }

    @GetMapping("/unknown")
    @PreAuthorize("hasRole('ROLE_ADMIN')" + " && " +"hasAuthority('user:read')")
    public String testUnknownPermission(){
        return "this should never work";
    }

}