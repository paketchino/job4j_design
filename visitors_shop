create table shop(
	id serial primary key,
	name varchar(255)
);

create table visitors(
	id serial primary key,
	name varchar(255),
	shop_id int references shop(id)
);
