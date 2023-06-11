package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;


@AllArgsConstructor
@RestController
public class PersonController {
    PersonRepository repository;

    @Secured("ROLE_WRITE")
    @GetMapping("/persons/by-city-and-age")
    public List<Person> getByCityAndAge(@RequestParam String city, @RequestParam int age){
        return repository.findByCityAndAge(city, age);
    }

    @PreAuthorize("hasRole('ROLE_DELETE')")
    @GetMapping("/persons/by-name-and-age")
    public List<Person> getByNameAndAge(@RequestParam String name, @RequestParam int age){
        return repository.findByNameAndAge(name, age);
    }

    @RolesAllowed("READ")
    @GetMapping("/persons/{id}")
    public Person getById(@PathVariable long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hello")
    public String helloUser(String username){
        return "Hello " + username;
    }


}
