package se.denize.examensarbete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.denize.examensarbete.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamensarbeteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void doesUserHaveName(){
		User user = new User("Stina");
		assertNotNull(user);
	}

}
