create table departments (
    id serial primary key,
    name varchar(255),
    doctor varchar(255)
);

create table patients (
    int serial primary key,
    name varchar(255),
    id_department int references departments(id)
);

insert into departments(name, doctor) values ('cardiology', 'Джек Воробей');
insert into departments(name, doctor) values ('psychiatry', 'Сквидвард');
insert into departments(name, doctor) values ('traumatology', 'Арни');

insert into patients(name, id_department) values ('Деви Джонс', 1);
insert into patients(name, id_department) values ('Танос', 2);
insert into patients(name, id_department) values ('Спанч Боб', 2);
insert into patients(name, id_department) values ('Чак Норрис', 3);
insert into patients(name, id_department) values ('Джеки Чан', 3);

select pp.name, p.name from departments as pp join patients as p on pp.id = p.id_department;
select pp.doctor, pp.name, p.name from departments as pp join patients as p on pp.id = p.id_department;
select pp.doctor as Доктор, pp.name as Отеделение, p.name as Пациент from departments as pp join patients as p on pp.id = p.id_department;