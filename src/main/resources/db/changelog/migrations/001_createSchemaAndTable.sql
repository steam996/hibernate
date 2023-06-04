--liquibase formatted sql

--changeset Andros:1
create table city
(
    id   bigserial primary key,
    city varchar(100) unique not null
);
-- rollback ;


--changeset Andros:2
create table person
(
    id          bigserial primary key,
    name        varchar(100) not null,
    surname     varchar(100) not null,
    age         int,
    phone_number varchar(12),
    city_id     bigint,
    foreign key (city_id) references city (id)
);
--rollback ;

