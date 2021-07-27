insert into role(name) values ('Admin');
insert into role(name) values ('User');

insert into users(name, role_id) values ('alexsey', 2);
insert into users(name, role_id) values ('roman', 1);

insert into rules (name) values ('Edit');
insert into rules (name) values ('Delete');
insert into rules (name) values ('Changed');

insert into rules (name) values ('Read');
insert into rules (name) values ('Create');

insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (1, 2);
insert into role_rules (role_id, rules_id) values (1, 3);

insert into role_rules (role_id, rules_id) values (2, 4);
insert into role_rules (role_id, rules_id) values (2, 5);

insert into states_item(name) values ('Decided');
insert into states_item(name) values ('Clarify data');
insert into states_item(name) values ('Waiting');

insert into category (name) values ('Important');
insert into category (name) values ('It is not important');

insert into item (name, users_id, states_item_id, category_id) values ('Changed document', 1, 1, 1);
insert into comment_item(name, item_id) values ('Delete Item', 1);

insert into file (name, item_id) values ('txt', 1);

select * from item;
select category from category;
