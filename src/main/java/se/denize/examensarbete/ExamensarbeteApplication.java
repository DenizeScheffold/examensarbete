package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.repository.WeekRepository;

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
                registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE")
                        .allowedOrigins("http://localhost:3000");
            }
        };
}
*/

/*
    @Bean
    public CommandLineRunner usersMockup(UserRepository repository) {
        return (args) -> {
            // mockup data
            repository.save(new User("Stina@gmail.com", 2L));
            repository.save(new User("Rut@hotmail.com", 1L));
        };
    }




    @Bean
    public CommandLineRunner weekMockup(WeekRepository weekRepository) {
        return (args) -> {
            // mockup data
            weekRepository.save(new Day(1202301091L, 2L, "MONDAY-RED", 1L));
            weekRepository.save(new Day(2202301091L, 2L, "MONDAY-RED",  2L));
            weekRepository.save(new Day(1202301092L, 2L, "MONDAY-GREEN", 1L));
            weekRepository.save(new Day(2202301092L, 2L, "MONDAY-GREEN",  2L));

        };

   }



 */
}
