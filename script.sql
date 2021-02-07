create database patients;
create table surgical (
                          id serial primary key,
                          name varchar(255),
                          age smallint,
                          healed boolean
);
insert into surgical(name, age, healed) values ('Иванов', 25, false);
update surgical set healed = true;
delete from surgical;