--liquibase formatted sql

--changeset Andros:1
create table person
(
    id   bigserial primary key,
    name varchar(100) not null,
    surname varchar(100) not null,
    age int,
    phone_number varchar(12),
    city varchar(100) not null
);
-- rollback ;
