create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Принтер', 4000);
insert into devices(name, price) values ('Сканер', 5000);
insert into devices(name, price) values ('Ноутбук', 60000);
insert into devices(name, price) values ('Смартфон', 30000);

insert into people(name) values ('Иван');
insert into people(name) values ('Василий');
insert into people(name) values ('Анатолий');
insert into people(name) values ('Инокентий');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (4, 2);
insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (4, 4);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
group by p.name
having min(d.price) > 5000;