package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

import java.util.List;

@Repository
public class HibernateRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public HibernateRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createNativeQuery("SELECT * FROM person WHERE city_id = " +
                        "(SELECT id FROM city where city ilike :city)", Person.class)
                .setParameter("city", city).getResultList();
    }
}
