package se.denize.examensarbete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class ExamensarbeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamensarbeteApplication.class, args);
	}

	@Bean
	public CommandLineRunner usersMockup(UserRepository repository) {
		return (args) -> {
			// mockup data
			repository.save(new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN")));
			repository.save(new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN")));
		};
	}

}
