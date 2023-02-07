package se.denize.examensarbete.authentication;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;

    private final DaoAuthenticationProvider authenticationOverride;

    @Autowired
    public JwtAuthenticationController(JwtTokenService tokenService,
                                     DaoAuthenticationProvider authenticationOverride) {
        this.tokenService = tokenService;
        this.authenticationOverride = authenticationOverride;

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