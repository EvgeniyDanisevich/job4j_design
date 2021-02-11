create table body (
    id serial primary key,
    name varchar(255)
);

create table engine (
    id serial primary key,
    name varchar(255)
);

create table transmission (
    id serial primary key,
    name varchar(255)
);

create table car (
    id serial primary key,
    name varchar(255),
    id_body int references body(id),
    id_engine int references engine(id),
    id_transmission int references transmission(id)
);

insert into body(name) values ('Внедорожник');
insert into body(name) values ('Хэтчбек');
insert into body(name) values ('Минивен');
insert into body(name) values ('Кабриолет');
insert into engine(name) values ('Бензиновый');
insert into engine(name) values ('Дизельный');
insert into engine(name) values ('Газовый');
insert into transmission(name) values ('Механическая');
insert into transmission(name) values ('Автоматическая');
insert into transmission(name) values ('Роботизированная');

insert into car(name, id_body, id_engine, id_transmission) values ('Renault Duster', 1, 2, 2);
insert into car(name, id_body, id_engine, id_transmission) values ('Chevrolet Express', 3, 1, 2);
insert into car(name, id_body, id_engine, id_transmission) values ('Lada 2106', 2, 1, 1);

select * from car c left join body b on c.id_body = b.id left join engine e on c.id_engine = e.id left join transmission t on c.id_transmission = t.id;

select * from body b left join car c on b.id = c.id_body where c.id_body is null;

select * from engine e left join car c on e.id = c.id_engine where c.id_engine is null;

select * from transmission t left join car c on t.id = c.id_transmission where c.id_transmission is null;