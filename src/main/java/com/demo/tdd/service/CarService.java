package com.demo.tdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.tdd.domain.Car;
import com.demo.tdd.exception.CarNotFoundException;
import com.demo.tdd.repository.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;

	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Cacheable("cars")
	public Car getCarDetails(String carName) {
		Car car = carRepository.findByName(carName);
		if (car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}

}
