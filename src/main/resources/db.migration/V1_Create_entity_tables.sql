create table users
(
    id            bigserial   not null,
    first_name    varchar(50) not null,
    surname       varchar(50) not null,
    phone_number  varchar(20) not null,
    email         varchar(50) not null,
    password_hash varchar(40) not null,
    primary key (id)
);

create table routes
(
    id        bigserial   not null,
    from_id   bigint      not null,
    to_id     bigint      not null,
    driver_id bigint,
    cost      money       not null,
    date      timestamptz not null,
    primary key (id)
);

create table user_routes
(
    user_id     bigint   not null,
    route_id    bigint   not null,
    seats_count smallint not null,
    primary key (user_id, route_id)
);

create table clients
(
    id      bigserial not null,
    user_id bigint    not null,
    primary key (id, user_id)
);

create table dispatchers
(
    id      bigserial not null,
    user_id bigint    not null,
    primary key (id, user_id)
);

create table drivers
(
    id      bigserial not null,
    user_id bigint    not null,
    bus_id  bigint    not null,
    primary key (id, user_id)
);

create table buses
(
    id           bigserial   not null,
    number_plate varchar(20) not null,
    color        varchar(20) not null,
    seats_count  int         not null,
    primary key (id)
);

create table stops
(
    id      bigserial   not null,
    name    varchar(50) not null,
    city_id bigint      not null,
    primary key (id)
);

create table cities
(
    id   bigserial   not null,
    name varchar(50) not null,
    primary key (id)
);

alter table routes
    add constraint route_from_fk
        foreign key (from_id) references stops;

alter table user_routes
    add constraint user_routes_user_fk
        foreign key (user_id) references users;

alter table user_routes
    add constraint user_routes_route_fk
        foreign key (route_id) references routes;

alter table routes
    add constraint route_to_fk
        foreign key (to_id) references stops;

alter table stops
    add constraint stop_city_fk
        foreign key (city_id) references cities;
