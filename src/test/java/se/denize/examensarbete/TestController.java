package se.denize.examensarbete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.denize.examensarbete.login.AppPasswordConfig;


@RestController
@RequestMapping("/rest")
public class TestController {


    private final AppPasswordConfig bcrypt;

    @Autowired
    public TestController(AppPasswordConfig bcrypt) {
        this.bcrypt = bcrypt;
    }


    @GetMapping("/encode")
    public String testEncoding() {
        return bcrypt.bCryptPasswordEncoder().encode("password");
    }
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