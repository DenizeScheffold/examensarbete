package se.denize.examensarbete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.denize.examensarbete.model.Weekday;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamensarbeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamensarbeteApplication.class, args);


	}
		public void setPlanUserA() {
			Map<String, String> planUserA = Stream.of(new Object[][] {

					{"Weekday.MONDAY", "Y"},
					{"Weekday.TUESDAY", "Y"},
			}).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

			System.out.println(planUserA.entrySet());


	}

}
