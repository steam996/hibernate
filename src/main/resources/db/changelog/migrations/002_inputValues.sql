--liquibase formatted sql

--changeset Andros:3
insert into city (city)
values ('Moscow'),
       ('SPB'),
       ('Omsk'),
       ('Eysk'),
       ('EKB');
--rollback ;

--changeset Andros:4
insert into person (name, surname, age, phone_number, city_id)
VALUES ('Oleg', 'Petrov', 18, '+79999999999', 1),
       ('Victor', 'Donscoy', 28, '+79999999999', 2),
       ('Igor', 'Romanov', 16, '+79999999999', 3),
       ('Roman', 'Letov', 36, '+79999999999', 4),
       ('Stepan', 'Petrov', 18, '+79999999999', 5),
       ('Leonid', 'Reznov', 18, '+79999999999', 1),
       ('Oleg', 'Ivanov', 18, '+79999999999', 3);
--rollback ;