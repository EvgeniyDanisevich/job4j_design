create table departments (
    id serial primary key,
    name varchar(255)
);

create table employees (
    id serial primary key,
    name varchar(255),
    id_department int references departments(id)
);

insert into departments(name) values ('surgical');
insert into departments(name) values ('therapy');
insert into departments(name) values ('traumatology');
insert into departments(name) values ('psychiatry');

insert into employees(name, id_department) values ('Иванов', 1);
insert into employees(name, id_department) values ('Петров', 1);
insert into employees(name, id_department) values ('Сидоров', 1);
insert into employees(name, id_department) values ('Хаус', 2);
insert into employees(name, id_department) values ('Форман', 2);
insert into employees(name, id_department) values ('Вилсон', 2);
insert into employees(name, id_department) values ('Илизаров', 3);
insert into employees(name, id_department) values ('Каплан', 3);
insert into employees(name, id_department) values ('Цивьян', 3);
insert into employees(name) values ('Лобанов');

select * from employees e left join departments d on e.id_department = d.id;
select * from departments d right join employees e on d.id = e.id_department;
select * from departments d cross join employees e;

select * from departments d left join employees e on d.id = e.id_department where e.id is null;

select * from employees e left join departments d on e.id_department = d.id;
select * from departments d right join employees e on d.id = e.id_department;

create table teens (
    id serial primary key,
    name varchar(255),
    gender boolean
);

insert into teens(name, gender) values ('Иван', true);
insert into teens(name, gender) values ('Анатолий', true);
insert into teens(name, gender) values ('Инокентий', true);
insert into teens(name, gender) values ('Мария', true);
insert into teens(name, gender) values ('Анна', true);
insert into teens(name, gender) values ('Татьяна', true);

select t1.name as М, t2.name as Ж, (t1.name, t2.name) as Пара from teens t1 cross join teens t2 where t1.gender is true and t1.gender != t2.gender;
