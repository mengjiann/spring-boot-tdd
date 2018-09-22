package com.demo.tdd.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.domain.Car;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void findByName() {

		// This will get the test entity manager to insert the object to the database
		// and get recreate it.
		// if were to use jpa save method, then you are just testing on the cache but not
		// the actual persistence
		Car savedCar = entityManager.persistFlushFind(new Car("prius2", "hybrid"));
		assertThat(savedCar.getId()).isNotNull().isNotNegative();
		Car car = repository.findByName("prius");

		assertThat(car.getName()).isEqualTo("prius");

	}

}
