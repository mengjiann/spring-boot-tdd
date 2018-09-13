package com.demo.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.domain.Car;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TddApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCar_returnsCarDetails() throws Exception {
		// arrange

		// act
		ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius",
				Car.class);

		// assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("prius");
		assertThat(response.getBody().getType()).isEqualTo("hybrid");

	}

}
