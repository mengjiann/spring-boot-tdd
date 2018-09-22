package com.demo.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.tdd.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	Car findByName(String carName);

}
