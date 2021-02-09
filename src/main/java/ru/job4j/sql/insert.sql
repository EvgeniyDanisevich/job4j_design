insert into rules(name) values ('Правило');
insert into roles(name) values ('Роль');
insert into roles_rules(role_id, rule_id) values (1, 1);
insert into categories(name) values ('Категория');
insert into states(name) values ('Состояние');
insert into users(name, role_id) values ('Иванов', 1);
insert into items(name, user_id, category_id, state_id) values ('Заявка', 1, 1, 1);
insert into comments(name, item_id) values ('Комментарий', 1);
insert into attaches(name, item_id) values ('Файл', 1);


