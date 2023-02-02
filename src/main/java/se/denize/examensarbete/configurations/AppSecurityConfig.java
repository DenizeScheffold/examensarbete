package se.denize.examensarbete.configurations;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;
/*
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {
    //implements WebMvcConfigurer {

    private final AppPasswordConfig bcrypt;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AppSecurityConfig(AppPasswordConfig bcrypt, UserServiceImpl userServiceImpl) {
        this.bcrypt = bcrypt;
        this.userServiceImpl = userServiceImpl;
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "/error", "/login",
                        "/api/**", "/rest/**", "/token/**")
                     //   , "localhost:8080/api/editDay/15", "/static/**")
                .permitAll()
                .requestMatchers("/adminPage").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .authenticationProvider(authenticationOverride());    //Tell Spring Security to use our implementation

        http.cors().configurationSource(request -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
            corsConfiguration.addAllowedMethod("DELETE");
            corsConfiguration.addAllowedMethod("POST");
            corsConfiguration.addAllowedMethod("GET");
            corsConfiguration.addAllowedMethod("PATCH");
            return corsConfiguration;

        });


        return http.build();
    }





    public DaoAuthenticationProvider authenticationOverride() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userServiceImpl);
        provider.setPasswordEncoder(bcrypt.bCryptPasswordEncoder());

        return provider;
    }


}*/


