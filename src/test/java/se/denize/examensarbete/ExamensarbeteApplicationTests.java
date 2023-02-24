package se.denize.examensarbete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		Day day = new Day(3,2L,new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-20"),2,false, false);
		assertNotNull(day);
	}

	//TODO: add test to solveConflict

/*@Test
public void withUserDetailsWhenAllEnabled() throws Exception {
  User expected = new User("rob", "pass", true, true, true, true, ROLE_12);
  UserDetails actual = User.withUserDetails(expected).build();
  assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
  assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
  assertThat(actual.getAuthorities()).isEqualTo(expected.getAuthorities());
  assertThat(actual.isAccountNonExpired()).isEqualTo(expected.isAccountNonExpired());
  assertThat(actual.isAccountNonLocked()).isEqualTo(expected.isAccountNonLocked());
  assertThat(actual.isCredentialsNonExpired()).isEqualTo(expected.isCredentialsNonExpired());
  assertThat(actual.isEnabled()).isEqualTo(expected.isEnabled());
}

@Test
public void withUserDetailsWhenAllDisabled() throws Exception {
  User expected = new User("rob", "pass", false, false, false, false, ROLE_12);
  UserDetails actual = User.withUserDetails(expected).build();
  assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
  assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
  assertThat(actual.getAuthorities()).isEqualTo(expected.getAuthorities());
  assertThat(actual.isAccountNonExpired()).isEqualTo(expected.isAccountNonExpired());
  assertThat(actual.isAccountNonLocked()).isEqualTo(expected.isAccountNonLocked());
  assertThat(actual.isCredentialsNonExpired()).isEqualTo(expected.isCredentialsNonExpired());
  assertThat(actual.isEnabled()).isEqualTo(expected.isEnabled());
}

*/


	/*
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SprintBootH2Application.class)
public class EmployeeRepositoryTest {
   @Autowired
   private EmployeeRepository employeeRepository;
   @Test
   public void testFindById() {
      Employee employee = getEmployee();
      employeeRepository.save(employee);
      Employee result = employeeRepository.findById(employee.getId()).get();
      assertEquals(employee.getId(), result.getId());
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
