package se.denize.examensarbete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.denize.examensarbete.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamensarbeteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void userCanBeCreated(){
		User user = new User("Stina", 1, List.of("MONDAY-RED", "MONDAY-GREEN"));
		assertNotNull(user);
	}

}
