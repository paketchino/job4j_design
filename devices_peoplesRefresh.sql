create table devices (
	id serial primary key,
	name_devices varchar (255),
	price float
);

create table peoples (
	id serial primary key,
	name_man varchar(255)
);

create table devices_peoples (
	id serial primary key,
	name_devices_id int references devices(id),
	name_man_id int references peoples(id)
);

insert into devices(name_devices, price) values ('Google Pixel 4', 45.990);
insert into devices(name_devices, price) values ('Google Pixel 2', 14.990);
insert into devices(name_devices, price) values ('Google Pixel 3a', 17.990);
insert into devices(name_devices, price) values ('Google Pixel 1', 9.990);
insert into devices(name_devices, price) values ('Apple Iphone 11', 69.990);
insert into devices(name_devices, price) values ('Apple Iphone 7', 27.990);
insert into devices(name_devices, price) values ('Apple Iphone 6', 15.990);
insert into devices(name_devices, price) values ('Apple Iphone 8', 35.990);
insert into devices(name_devices, price) values ('Apple Iphone SE 2020', 48.990);
insert into devices(name_devices, price) values ('Huawei Mate 20 PRO', 32.990);
insert into devices(name_devices, price) values ('Huawei Honor 10', 19.990);
insert into devices(name_devices, price) values ('Huawei Honor 20', 26.990);
insert into devices(name_devices, price) values ('Huawei Honor 10X', 8.990);
insert into devices(name_devices, price) values ('Xiaomi Mi A2 Lite', 13.590);
insert into devices(name_devices, price) values ('Xiaomi PocoFon F1', 22.990);

insert into peoples (name_man) values ('Sergey');
insert into peoples (name_man) values ('Roman');
insert into peoples (name_man) values ('Maksim');
insert into peoples (name_man) values ('Stas');
insert into peoples (name_man) values ('Pavel');

insert into devices_peoples (name_man_id, name_devices_id) values (1, 14);
insert into devices_peoples (name_man_id, name_devices_id) values (1, 12);
insert into devices_peoples (name_man_id, name_devices_id) values (1, 10);
insert into devices_peoples (name_man_id, name_devices_id) values (2, 1);
insert into devices_peoples (name_man_id, name_devices_id) values (2, 2);
insert into devices_peoples (name_man_id, name_devices_id) values (2, 3);
insert into devices_peoples (name_man_id, name_devices_id) values (2, 4);
insert into devices_peoples (name_man_id, name_devices_id) values (3, 5);
insert into devices_peoples (name_man_id, name_devices_id) values (3, 6);
insert into devices_peoples (name_man_id, name_devices_id) values (3, 7);
insert into devices_peoples (name_man_id, name_devices_id) values (4, 8);
insert into devices_peoples (name_man_id, name_devices_id) values (4, 9);
insert into devices_peoples (name_man_id, name_devices_id) values (5, 11);
insert into devices_peoples (name_man_id, name_devices_id) values (5, 13);

select avg(price) as Средняя_цена from devices;

select dp.name_man_id as Пользователи_телефонов, avg(d.price) as Средняя_цена 
from devices_peoples as dp join devices as d on dp.name_devices_id = d.id
group by dp.name_man_id;

select dp.name_man_id as Пользователи_телефонов, avg(d.price) as Средняя_цена 
from devices_peoples as dp join devices as d on dp.name_devices_id = d.id
group by dp.name_man_id
having avg(d.price) > 10.000;