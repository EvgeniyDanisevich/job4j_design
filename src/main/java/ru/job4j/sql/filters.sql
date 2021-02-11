create table type (
    id serial primary key,
    name varchar(255)
);

create table products (
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price int
);

insert into type(name) values ('МОЛОКО');
insert into type(name) values ('ХЛЕБ');
insert into type(name) values ('СЫР');

insert into products(name, type_id, expired_date, price) values ('Молоко', 1, '2021-02-18', 100);
insert into products(name, type_id, expired_date, price) values ('Кефир', 1, '2021-02-28', 150);
insert into products(name, type_id, expired_date, price) values ('Мороженное', 1, '2021-03-30', 50);
insert into products(name, type_id, expired_date, price) values ('Серый хлеб', 2, '2021-03-10', 100);
insert into products(name, type_id, expired_date, price) values ('Черный хлеб', 2, '2021-03-20', 100);
insert into products(name, type_id, expired_date, price) values ('Белый хлеб', 2, '2021-03-07', 100);
insert into products(name, type_id, expired_date, price) values ('Пармезан', 3, '2021-08-01', 1000);
insert into products(name, type_id, expired_date, price) values ('Рокфор', 3, '2021-08-01', 900);
insert into products(name, type_id, expired_date, price) values ('Швейцарский', 3, '2021-08-01', 1500);

select * from products where type_id = (select id from type where name = 'СЫР');
select * from products where lower (name) like '%мороженное%';
select * from products where date_part ('month', expired_date) = date_part ('month', (current_date + interval '1 month'));
select * from products where price = (select max(price) from products);
select count(*) from products where type_id = (select id from type where name = 'ХЛЕБ');
select * from products where type_id in (select id from type where name = 'СЫР' or name ='МОЛОКО');

select type.name, count(products.name) from products join type on products.type_id = type.id
group by type.name
having count(products.name) < 10;

select p.id, p.name, type.name, p.expired_date, p.price from products as p join type on p.type_id = type.id;

