package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.DayRepository;
import se.denize.examensarbete.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class ExamensarbeteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamensarbeteApplication.class, args);
    }


/*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE", "PATCH")
                        .allowedOrigins("http://localhost:3000");
            }
        };
}

 */

/*
    @Bean
    public CommandLineRunner usersMockup(UserRepository repository) {
        AppPasswordConfig bcrypt = new AppPasswordConfig();
        return (args) -> {
            // mockup data
          repository.save(new User(
                    "Stina@stinis.se",
                    2L,
                    "Stinis",
                    bcrypt.bCryptPasswordEncoder().encode("abb"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));
          repository.save(new User(
                    "Kattis@gmail.com",
                    1L,
                    "Kattis",
                    bcrypt.bCryptPasswordEncoder().encode("abb"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));


            repository.save(new User(
                    "Jasmin@jasmin.se",
                    2L,
                    "Jasmin",
                    bcrypt.bCryptPasswordEncoder().encode("abb"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));
        };
     }

          */

/*


    @Bean
    public CommandLineRunner weekMockup(DayRepository dayRepository) {

        return (args) -> {

            // mockup data
            dayRepository.save(new Day(2, 1L, LocalDate.of(2023,1,9), 1, false, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,10),1,false, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,11),1,false,false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,12),1,true, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,13),1,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,9),1,true, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,10),1,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,11),1,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,12),1,true, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,13),1,false, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,9),2,false, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,10),2,true, false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,11),2,false,false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,12),2,false,false));
            dayRepository.save(new Day(2,1L,LocalDate.of(2023,1,13),2,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,9),2,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,10),2,true, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,11),2,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,12),2,false, false));
            dayRepository.save(new Day(2,2L,LocalDate.of(2023,1,13),2,true, false));



            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,16),1,true, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,17),1,false, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,18),1,true, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,19),1,false, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,20),1,false, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,16),1,true, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,17),1,false, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,18),1,false, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,19),1,true, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,20),1,false, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,16),2,null, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,17),2,null, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,18),2,null, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,19),2,null, false));
            dayRepository.save(new Day(3,1L,LocalDate.of(2023,1,20),2,null, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,16),2,null, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,17),2,null, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,18),2,null, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,19),2,null, false));
            dayRepository.save(new Day(3,2L,LocalDate.of(2023,1,20),2,null, false));



};
        }

             */









}
