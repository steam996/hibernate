--liquibase formatted sql

--changeset Andros:2
INSERT INTO person (name, surname, age, phone_number, city)
VALUES ('Oleg','Petrov',18,'+79999999999', 'Moscow'),
       ('Victor','Donscoy',28,'+79999999999','SPB'),
       ('Igor','Romanov',16,'+79999999999','Omsk'),
       ('Roman','Letov',36,'+79999999999', 'Eysk'),
       ('Stepan','Petrov',18,'+79999999999', 'EKB'),
       ('Leonid','Reznov',18,'+79999999999', 'Moscow'),
       ('Oleg','Ivanov',18,'+79999999999','EKB')
-- rollback ;

