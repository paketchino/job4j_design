create table departments (
	id serial primary key,
	name text
);

create table emploess (
	id serial primary key,
	emploess text,
	departments_id int references departments(id)
);

insert into departments (name) values ('A1'), ('C1'), ('J4');

insert into emploess (emploess, departments_id) values 
('Roman', 1),
('Vova', 1),
('Sergey', 1),
('Sanya', 1), 
('Misha', 1),
('Anna', 2),
('Pasha', 2),
('Alexsey', null);

select * from emploess as e left join departments as d on e.departments_id = d.id;
select * from departments as d right join emploess as e on d.id = e.departments_id;
select * from emploess as e cross join departments as d;
select * from emploess as e full join departments as d on e.departments_id = d.id;
select d.id, d.name from departments as d left join emploess as e on d.id = e.departments_id where e.id is null;

select * from departments as d right join emploess as e on d.id = e.departments_id;
select * from departments as d left join emploess as e on e.departments_id = d.id;

select * from emploess as e left join departments as d on e.departments_id = d.id;
select * from emploess as e right join departments as d on e.departments_id = d.id;