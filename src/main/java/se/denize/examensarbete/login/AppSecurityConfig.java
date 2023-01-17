package se.denize.examensarbete.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig implements WebMvcConfigurer {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests ()
                    .requestMatchers ("/", "/error", "/login", "/api/getPlans","/api/getPlans","/api/getPlanForUser1/*", "/api/getPlanForUser2/*", "/api/*", "/api/setPlans").permitAll()
                    .requestMatchers ("/adminPage" ).hasRole("ADMIN")
                    .anyRequest().authenticated ()
                    .and()
                    .formLogin();
            return http.build();

    }

}


