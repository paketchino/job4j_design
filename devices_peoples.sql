create table devices (
	id serial primary key,
	name_phone varchar(255)
	price float,
);

create table peoples (
	id serial primary key,
	name_peoples varchar(255)
);

create table devices_people (
	id serial primary key,
	peoples_id int references peoples(id),
	devices_id int references devices(id)
);

insert into devices (name_phone, price) values ('Google Pixel 4 256 gb', 44.999);
insert into devices (name_phone, price) values ('Google Pixel 3a 128 gb', 25.000);
insert into devices (name_phone, price) values ('Google Pixel 2 65 gb', 15.000);
insert into devices (name_phone, price) values ('Apple Iphone 11 512 gb', 56.990);
insert into devices (name_phone, price) values ('Apple Iphone 8 256 gb', 33.500);
insert into devices (name_phone, price) values ('Apple Iphone 7 128 gb', 25.780);
insert into devices (name_phone, price) values ('Samsung Galaxy S10 512gb', 65.505);
insert into devices (name_phone, price) values ('Huawei Mate 20 PRO 256 gb', 89.670);
insert into devices (name_phone, price) values ('Xiaomi Mi A2 Lite 64gb', 11.000);

insert into peoples (name_peoples) values ('Sergey');
insert into peoples (name_peoples) values ('Roman');
insert into peoples (name_peoples) values ('Evgenya');
insert into peoples (name_peoples) values ('Sasha');
insert into peoples (name_peoples) values ('Igor');

insert into devices_people (peoples_id, devices_id) values (1, 1);
insert into devices_people (peoples_id, devices_id) values (1, 2);
insert into devices_people (peoples_id, devices_id) values (1, 3);
insert into devices_people (peoples_id, devices_id) values (2, 4);
insert into devices_people (peoples_id, devices_id) values (2, 5);
insert into devices_people (peoples_id, devices_id) values (2, 6);
insert into devices_people (peoples_id, devices_id) values (3, 7);
insert into devices_people (peoples_id, devices_id) values (4, 8);
insert into devices_people (peoples_id, devices_id) values (5, 9);

select avg (price) from devices_people;

select p.name_peoples, avg (d.price) from devices as d join peoples as pp on d.price = pp.