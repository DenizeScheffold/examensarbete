package se.denize.examensarbete;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.controller.UserController;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.service.AuthService;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExamensarbeteApplicationTests {




	@Test
	void contextLoads() {
	}

	@Test
	void userCanBeCreated(){
		User user = new User("Rut@hotmail.com", 1L);
		assertNotNull(user);
	}
	@Test
	void dayCanBeCreated() throws ParseException {
		Day day = new Day(3,2L, LocalDate.of(2023,1,20),2,false, false);
		assertNotNull(day);
	}

	//TODO: add test to solveConflict

@Test
public void withUserDetailsWhenAllEnabled(){
  User testUser = new User("email@email.se", 1L, "rob", "pass", UserRoles.ADMIN, true, true, true, true);
  assertNotNull(testUser.getUsername());
  assertNotNull(testUser.getEmail());
  assertNotNull(testUser.getPassword());
  assertNotNull(testUser.getRole());
  assertTrue(testUser.isEnabled());
  assertTrue(testUser.isAccountNonExpired());
  assertTrue(testUser.isAccountNonLocked());
  assertTrue(testUser.isCredentialsNonExpired());

}

@Test
public void withUserDetailsWhenAllDisabled() throws Exception {
	User testUser = new User("email@email.se", 1L, "rob", "pass", UserRoles.ADMIN, false, false, false, false);
	assertNotNull(testUser.getUsername());
	assertNotNull(testUser.getEmail());
	assertNotNull(testUser.getPassword());
	assertNotNull(testUser.getRole());
	assertFalse(testUser.isEnabled());
	assertFalse(testUser.isAccountNonExpired());
	assertFalse(testUser.isAccountNonLocked());
	assertFalse(testUser.isCredentialsNonExpired());

}
	@Test
	public void whenValidUsername_thenUsernameShouldFound(){
		UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);
		//AuthService authService = Mockito.mock(AuthService.class);
		//UserController userController = new UserController(userService, authService);
		String username = "Stinis";
		User found = userService.loadUserByUsername(username);
		assertEquals(username,found.getUsername());
	}



   /*
   @Test
   public void testFindById() {
	   User testUser = new User("email@email.se", 1L, "rob", "pass", UserRoles.ADMIN, false, false, false, false);

   //   User result = userRepo.findById(employee.getId()).get();
      //assertEquals(employee.getId(), result.getId());
   }

   @Test
   public void testFindAll() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      List<Employee> result = new ArrayList<>();
      employeeRepository.findAll().forEach(e -> result.add(e));
      assertEquals(result.size(), 1);
   }
   @Test
   public void testSave() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      Employee found = employeeRepository.findById(employee.getId()).get();
      assertEquals(employee.getId(), found.getId());
   }
   @Test
   public void testDeleteById() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      employeeRepository.deleteById(employee.getId());
      List<Employee> result = new ArrayList<>();
      employeeRepository.findAll().forEach(e -> result.add(e));
      assertEquals(result.size(), 0);
   }
   private Employee getEmployee() {
      Employee employee = new Employee();
      employee.setId(1);
      employee.setName("Mahesh");
      employee.setAge(30);
      employee.setEmail("mahesh@test.com");
      return employee;
   }
   @Test
   public void testFindByName() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      List<Employee> result = new ArrayList<>();
      employeeRepository.findByName(employee.getName()).forEach(e -> result.add(e));
      assertEquals(result.size(), 1);
   }
   @Test
   public void testFindByAge() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      List<Employee> result = new ArrayList<>();
      employeeRepository.findByAge(employee.getAge()).forEach(e -> result.add(e));
      assertEquals(result.size(), 1);
   }
   @Test
   public void testFindByEmail() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      Employee result = employeeRepository.findByEmail(employee.getEmail());
      assertNotNull(result);
   }
   @Test
   public void testFindAllSortedByName() {
      Employee employee = getEmployee();
      Employee employee1 = new Employee();
      employee1.setId(2);
      employee1.setName("Aarav");
      employee1.setAge(20);
      employee1.setEmail("aarav@test.com");
      employeeRepository.save(employee);
      employeeRepository.save(employee1);
      List<Employee> result = employeeRepository.findAllSortedByName();
      assertEquals(employee1.getName(), result.get(0).getName());
   }
}


	 */

}
