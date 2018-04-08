package com.demo.tdd.domain;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
