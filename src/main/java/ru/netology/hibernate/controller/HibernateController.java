package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class HibernateController {
    private final PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return repository.findLessThanAgeAndOrderByAge(age);
    }

    @GetMapping("/person/by-name-surname")
    public Person getPersonByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return repository.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
