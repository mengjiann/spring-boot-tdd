package com.demo.tdd;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.domain.Car;
import com.demo.tdd.repository.CarRepository;
import com.demo.tdd.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CachingTest {

	// Will require the spring application content for testing on the cache.
	// Therefore, will need to include the spring boot test.
	// But, since we do not require to test on the server, we will change the web
	// environment to none.

	// Can also specify the cache config class

	@Autowired
	private CarService service;

	@MockBean
	private CarRepository carRepository;

	@Test
	public void caching() throws Exception {

		given(carRepository.findByName(anyString()))
				.willReturn(new Car("prius", "hybrid"));

		service.getCarDetails("prius");
		service.getCarDetails("prius");

		verify(carRepository, times(1)).findByName("prius");
	}

}
