package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public HibernateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        return getAllPerson()
                .stream()
                .filter((x)-> x.getCity().equals(city))
                .collect(Collectors.toList());
    }

    private List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        long count = 1L;
        while (true) {
            var result = entityManager.find(Person.class, count);
            if (result == null) break;
            count++;
            personList.add(result);
        }
        return personList;
    }
}
