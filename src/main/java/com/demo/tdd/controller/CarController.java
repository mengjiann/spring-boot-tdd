package com.demo.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tdd.domain.Car;
import com.demo.tdd.exception.CarNotFoundException;
import com.demo.tdd.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CarController {

	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	private Car getCart(@PathVariable("name") String carName) {
		return carService.getCarDetails(carName);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void carNotFoundHandler(CarNotFoundException ex) {
		log.error("Entering and leaving CarController : carNotFoundHandler");
	}

}
