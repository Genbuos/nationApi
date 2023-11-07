package com.example.nationalites;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Data
public class Person {
    private String name;

    private Integer count;

    private Country[] country;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", country=" + Arrays.toString(country) +
                '}';
    }
}
