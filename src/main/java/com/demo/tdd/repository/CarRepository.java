package com.demo.tdd.repository;

import com.demo.tdd.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findByName(String carName);
}
