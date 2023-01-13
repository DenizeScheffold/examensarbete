package se.denize.examensarbete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;

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
	void dayCanBeCreated(){
		Day day = new Day(1202301101L, 2L, "MONDAY-RED", 1L);
		assertNotNull(day);
	}


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
