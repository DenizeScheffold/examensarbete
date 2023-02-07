package se.denize.examensarbete.authentication;

        import lombok.RequiredArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import se.denize.examensarbete.model.User;
        import se.denize.examensarbete.service.AuthService;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;

    private final DaoAuthenticationProvider authenticationOverride;
    private final AuthService authService;


    @PostMapping("/signup")
    public void createUser(@RequestBody UserRequest userRequest){
         authService.createUser(userRequest);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody JwtTokenRequest jwtTokenRequest) {

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        jwtTokenRequest.username(),
                        jwtTokenRequest.password());

        var authentication =
                authenticationOverride.authenticate(authenticationToken);

        var token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }
}