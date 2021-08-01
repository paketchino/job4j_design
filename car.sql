create table body (
	id serial primary key,
	body varchar(255)
);

create table engine (
	id serial primary key,
	engine varchar(255)
);

create table gearbox (
	id serial primary key,
	gearbox varchar(255)
);

create table car (
	id serial primary key,
	car_name varchar(255),
	gearbox_id int references gearbox(id),
	engine_id int references engine(id),
	body_id int references body(id)
);

insert into body (body) values ('Lada');
insert into body (body) values ('Posche');
insert into body (body) values ('Mercedes');
insert into body (body) values ('Lamborgini');
insert into body (body) values ('Tesla');
insert into engine (engine) values ('Lada V1');
insert into engine (engine) values ('Posche V2');
insert into engine (engine) values ('Mercedes V3');
insert into engine (engine) values ('BMW');
insert into gearbox (gearbox) values ('Gearbox from Lada V1');
insert into gearbox (gearbox) values ('Posche from Posche V2');
insert into gearbox (gearbox) values ('Mercedes from Mercedes V3');
insert into gearbox (gearbox) values ('Niva');
insert into car(car_name, gearbox_id, engine_id, body_id) values ('Lada Grante', 1, 1, 1);
insert into car(car_name, gearbox_id, engine_id, body_id) values ('Posrhe 911', 2, 2, 2);
insert into car(car_name, gearbox_id, engine_id, body_id) values ('Mercedes Benz', 3, 3, 3);

select car_name as Название_машины, gearbox_id as Коробка_Передач, engine_id as Двигатель, body_id as Кузов from car as c 
inner join gearbox as g on c.gearbox_id = g.id
inner join engine as e on c.engine_id = e.id
inner join body as b on c.body_id = b.id;

select g.gearbox as Коробка_Передач from gearbox as g left join car as c on c.gearbox_id = g.id where c.id is null;
select e.engine as Двигатель from engine as e left join car as c on c.engine_id = e.id where c.id is null;
select b.body as Кузов from body as b left join car as c on c.body_id = b.id where c.id is null;