package se.denize.examensarbete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;


@RestController
@RequestMapping("/rest")
public class TestController {


    private final AppPasswordConfig bcrypt;
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @Autowired
    public TestController(AppPasswordConfig bcrypt, UserRepository userRepository, UserServiceImpl userService) {
        this.bcrypt = bcrypt;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/find/{username}")
    public UserDetails findByUsername(@PathVariable String username){
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/saveRut")
    public User saveUserRut(){

        User rut = new  User(
                "rut@rutan.se",
                2L,
                "rutan",
                bcrypt.bCryptPasswordEncoder().encode("123"),
                UserRoles.ADMIN.getGrantedAuthorities(),
                true,
                true,
                true,
                true
        );

        return userRepository.save(rut);
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