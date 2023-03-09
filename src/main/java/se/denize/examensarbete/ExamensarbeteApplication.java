package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.DayRepository;

import java.time.LocalDate;

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




    @Bean
    public CommandLineRunner weekMockup(DayRepository dayRepository) {

        return (args) -> {
            dayRepository.deleteAll();
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

            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,23),1,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,24),1,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,25),1,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,26),1,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,27),1,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,23),1,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,24),1,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,25),1,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,26),1,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,27),1,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,23),2,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,24),2,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,25),2,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,26),2,null, null));
            dayRepository.save(new Day(4,1L,LocalDate.of(2023,1,27),2,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,23),2,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,24),2,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,25),2,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,26),2,null, null));
            dayRepository.save(new Day(4,2L,LocalDate.of(2023,1,27),2,null, null));


        dayRepository.save(new Day(5,1L,LocalDate.of(2023,1,30),1,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,1,31),1,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,1),1,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,2),1,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,3),1,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,1,30),1,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,1,31),1,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,1),1,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,2),1,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,3),1,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,1,30),2,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,1,31),2,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,1),2,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,2),2,null, null));
        dayRepository.save(new Day(5,1L,LocalDate.of(2023,2,3),2,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,1,30),2,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,1,31),2,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,1),2,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,2),2,null, null));
        dayRepository.save(new Day(5,2L,LocalDate.of(2023,2,3),2,null, null));


            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,6),1,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,7),1,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,8),1,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,9),1,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,10),1,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,6),1,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,7),1,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,8),1,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,9),1,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,10),1,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,6),2,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,7),2,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,8),2,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,9),2,null, null));
            dayRepository.save(new Day(6,1L,LocalDate.of(2023,2,10),2,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,6),2,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,7),2,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,8),2,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,9),2,null, null));
            dayRepository.save(new Day(6,2L,LocalDate.of(2023,2,10),2,null, null));



            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,13),1,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,14),1,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,15),1,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,16),1,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,17),1,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,13),1,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,14),1,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,15),1,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,16),1,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,17),1,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,13),2,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,14),2,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,15),2,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,16),2,null, null));
            dayRepository.save(new Day(7,1L,LocalDate.of(2023,2,17),2,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,13),2,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,14),2,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,15),2,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,16),2,null, null));
            dayRepository.save(new Day(7,2L,LocalDate.of(2023,2,17),2,null, null));




            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,20),1,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,21),1,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,22),1,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,23),1,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,24),1,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,20),1,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,21),1,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,22),1,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,23),1,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,24),1,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,20),2,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,21),2,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,22),2,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,23),2,null, null));
            dayRepository.save(new Day(8,1L,LocalDate.of(2023,2,24),2,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,20),2,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,21),2,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,22),2,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,23),2,null, null));
            dayRepository.save(new Day(8,2L,LocalDate.of(2023,2,24),2,null, null));


        };



    }




}
