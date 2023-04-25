package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.DayRepository;
import se.denize.examensarbete.repository.UserRepository;

import java.time.LocalDate;

@SpringBootApplication
public class ExamensarbeteApplication {
    private final UserRepository userRepository;

    public ExamensarbeteApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    @Bean
    public CommandLineRunner usersMockup(UserRepository repository) {
        //Populates db with two users. Everytime application is started db re-populates.
        AppPasswordConfig bcrypt = new AppPasswordConfig();
        return (args) -> {
            repository.deleteAll();
          User parent = repository.save(new User(
                    "Stina@stinis.se",
                    2L,
                    "Stinis",
                    bcrypt.bCryptPasswordEncoder().encode("abb"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));

          User coParent = repository.save(new User(
                  "Kattis@gmail.com",
                    1L,
                    "Kattis",
                    bcrypt.bCryptPasswordEncoder().encode("abb"),
                    UserRoles.ADMIN,
                    true,
                    true,
                    true,
                    true));

          coParent.setOtherParentId(parent.getUserId());
          repository.save(coParent);

          parent.setOtherParentId(coParent.getUserId());
          repository.save(parent);

    };
     }


    @Bean
    public CommandLineRunner weekMockup(DayRepository dayRepository) {
        //Populates db with days for the two users. Everytime application is started db re-populates.
        return (args) -> {
            Long parent1 = userRepository.findByUsername("Stinis").getUserId();
            Long parent2 = userRepository.findByUsername("Kattis").getUserId();

            dayRepository.deleteAll();
           // mockup data
            dayRepository.save(new Day(2, parent1, LocalDate.of(2023,1,9), 1, true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,10),1,true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,11),1,true,true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,12),1,true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,13),1,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,9),1,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,10),1,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,11),1,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,12),1,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,13),1,true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,9),2,true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,10),2,true, true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,11),2,true,true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,12),2,false,true));
            dayRepository.save(new Day(2,parent1,LocalDate.of(2023,1,13),2,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,9),2,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,10),2,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,11),2,false, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,12),2,true, true));
            dayRepository.save(new Day(2,parent2,LocalDate.of(2023,1,13),2,true, true));


            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,16),1,true, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,17),1,false, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,18),1,true, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,19),1,false, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,20),1,false, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,16),1,true, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,17),1,false, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,18),1,false, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,19),1,true, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,20),1,false, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,16),2,true, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,17),2,true, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,18),2,false, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,19),2,false, false));
            dayRepository.save(new Day(3,parent1,LocalDate.of(2023,1,20),2,false, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,16),2,true, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,17),2,true, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,18),2,false, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,19),2,true, false));
            dayRepository.save(new Day(3,parent2,LocalDate.of(2023,1,20),2,true, false));

            /*
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,23),1,true, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,24),1,false, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,25),1,false, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,26),1,true, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,27),1,false, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,23),1,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,24),1,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,25),1,false, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,26),1,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,27),1,true, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,23),2,false, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,24),2,false, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,25),2,false, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,26),2,true, false));
            dayRepository.save(new Day(4,parent1,LocalDate.of(2023,1,27),2,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,23),2,false, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,24),2,false, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,25),2,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,26),2,true, false));
            dayRepository.save(new Day(4,parent2,LocalDate.of(2023,1,27),2,true, false));
*/

        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,1,30),1,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,1,31),1,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,1),1,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,2),1,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,3),1,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,1,30),1,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,1,31),1,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,1),1,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,2),1,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,3),1,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,1,30),2,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,1,31),2,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,1),2,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,2),2,null, null));
        dayRepository.save(new Day(5,parent1,LocalDate.of(2023,2,3),2,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,1,30),2,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,1,31),2,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,1),2,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,2),2,null, null));
        dayRepository.save(new Day(5,parent2,LocalDate.of(2023,2,3),2,null, null));


            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,6),1,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,7),1,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,8),1,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,9),1,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,10),1,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,6),1,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,7),1,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,8),1,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,9),1,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,10),1,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,6),2,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,7),2,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,8),2,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,9),2,null, null));
            dayRepository.save(new Day(6,parent1,LocalDate.of(2023,2,10),2,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,6),2,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,7),2,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,8),2,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,9),2,null, null));
            dayRepository.save(new Day(6,parent2,LocalDate.of(2023,2,10),2,null, null));


            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,13),1,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,14),1,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,15),1,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,16),1,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,17),1,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,13),1,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,14),1,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,15),1,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,16),1,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,17),1,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,13),2,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,14),2,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,15),2,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,16),2,null, null));
            dayRepository.save(new Day(7,parent1,LocalDate.of(2023,2,17),2,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,13),2,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,14),2,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,15),2,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,16),2,null, null));
            dayRepository.save(new Day(7,parent2,LocalDate.of(2023,2,17),2,null, null));


            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,20),1,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,21),1,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,22),1,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,23),1,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,24),1,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,20),1,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,21),1,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,22),1,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,23),1,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,24),1,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,20),2,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,21),2,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,22),2,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,23),2,null, null));
            dayRepository.save(new Day(8,parent1,LocalDate.of(2023,2,24),2,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,20),2,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,21),2,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,22),2,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,23),2,null, null));
            dayRepository.save(new Day(8,parent2,LocalDate.of(2023,2,24),2,null, null));


        };

    }

    //FOR TESTING:
/*
    @Bean(name = "userDao")
    UserDAO getUserDao(){
        return new UserDAO(userRepository);
    }

    @Bean(name = "userService")
    UserServiceImpl getUserService(){
        return new UserServiceImpl(getUserDao());
    }

 */
/*
    @Bean(name = "user")
    @Scope(value = "prototype")
    User getUser(){
        return new User();
    }

 */



}
