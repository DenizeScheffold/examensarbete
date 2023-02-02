package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

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
                    bcrypt.bCryptPasswordEncoder().encode("123456789"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));
          repository.save(new User(
                    "Kattis@gmail.com",
                    1L,
                    "Kattis",
                    bcrypt.bCryptPasswordEncoder().encode("123456789"),
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
    public CommandLineRunner weekMockup(WeekRepository weekRepository) {
        return (args) -> {
            // mockup data
            weekRepository.save(new Day(2,1L,"2023-01-09",1,false));
            weekRepository.save(new Day(2,1L,"2023-01-10",1,true));
            weekRepository.save(new Day(2,1L,"2023-01-11",1,false));
            weekRepository.save(new Day(2,1L,"2023-01-12",1,false));
            weekRepository.save(new Day(2,1L,"2023-01-13",1,true));
            weekRepository.save(new Day(2,2L,"2023-01-09",1,false));
            weekRepository.save(new Day(2,2L,"2023-01-10",1,false));
            weekRepository.save(new Day(2,2L,"2023-01-11",1,true));
            weekRepository.save(new Day(2,2L,"2023-01-12",1,false));
            weekRepository.save(new Day(2,2L,"2023-01-13",1,false));
            weekRepository.save(new Day(2,1L,"2023-01-09",2,false));
            weekRepository.save(new Day(2,1L,"2023-01-10",2,true));
            weekRepository.save(new Day(2,1L,"2023-01-11",2,false));
            weekRepository.save(new Day(2,1L,"2023-01-12",2,false));
            weekRepository.save(new Day(2,1L,"2023-01-13",2,false));
            weekRepository.save(new Day(2,2L,"2023-01-09",2,false));
            weekRepository.save(new Day(2,2L,"2023-01-10",2,true));
            weekRepository.save(new Day(2,2L,"2023-01-11",2,false));
            weekRepository.save(new Day(2,2L,"2023-01-12",2,false));
            weekRepository.save(new Day(2,2L,"2023-01-13",2,true));
            weekRepository.save(new Day(3,1L,"2023-01-16",1,true));
            weekRepository.save(new Day(3,1L,"2023-01-17",1,false));
            weekRepository.save(new Day(3,1L,"2023-01-18",1,true));
            weekRepository.save(new Day(3,1L,"2023-01-19",1,false));
            weekRepository.save(new Day(3,1L,"2023-01-20",1,false));
            weekRepository.save(new Day(3,2L,"2023-01-16",1,true));
            weekRepository.save(new Day(3,2L,"2023-01-17",1,false));
            weekRepository.save(new Day(3,2L,"2023-01-18",1,false));
            weekRepository.save(new Day(3,2L,"2023-01-19",1,true));
            weekRepository.save(new Day(3,2L,"2023-01-20",1,false));
            weekRepository.save(new Day(3,1L,"2023-01-16",2,false));
            weekRepository.save(new Day(3,1L,"2023-01-17",2,true));
            weekRepository.save(new Day(3,1L,"2023-01-18",2,false));
            weekRepository.save(new Day(3,1L,"2023-01-19",2,true));
            weekRepository.save(new Day(3,1L,"2023-01-20",2,false));
            weekRepository.save(new Day(3,2L,"2023-01-16",2,true));
            weekRepository.save(new Day(3,2L,"2023-01-17",2,false));
            weekRepository.save(new Day(3,2L,"2023-01-18",2,true));
            weekRepository.save(new Day(3,2L,"2023-01-19",2,false));
            weekRepository.save(new Day(3,2L,"2023-01-20",2,false));

}
        };*/




}
