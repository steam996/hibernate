package ru.netology.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table( schema = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person  {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    private City city;


}
