create table users (
	id serial primary key,
	name text,
	role_id int references role(id)
);

create table role (
	id serial primary key,
	name text,
);

create table rules(
	id serial primary key,
	name text
);

create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table states_item (
	id serial primary key, 
	name text
);

create table category (
	id serial primary key, 
	name text
);

create table item (
	id serial primary key,
	name text,
	users_id int references users(id),
	states_item_id int references states_item(id),
	category_id int references category(id)
);

create table comment_item (
	id serial primary key,
	name text,
	item_id int references item(id)
);

create table file (
	id serial primary key,
	name text,
	item_id int references item(id)
);
insert into role(name, users_id) values ('Admin', 1);
insert into role(name, users_id) values ('User', 2);

insert into users(name) values ('alexsey', 2);
insert into users(name) values ('roman', 1);

insert into rules (name, role_id) values ('Edit', 1);
insert into rules (name, role_id) values ('Delete', 1);
insert into rules (name, role_id) values ('Changed', 1);

insert into rules (name, role_id) values ('Read', 2);
insert into rules (name, role_id) values ('Create', 2);

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

insert into item (name, users_id, role_id, rules_id) values ('Changed document', 2, 3, 2);
insert into comment_item(name, item_id) values ('Delete Item', 1);

insert into file (name, item_id) values ('txt', 1);


