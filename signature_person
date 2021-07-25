
create table person (
		id serial primary key,
		first_name varchar(255),
		second_name varchar(255)
);

create table signature (
		id serial primary key,
		name varchar(255),
		person_id int references person (id) unique
);

insert into person (name) values ('Roman','Kulyanin');
insert into person (name) values ('Maksim','Fedorovich');
insert into signature (name, person_id) values ('AFA' , 1);
insert into signature (name, person_id) values ('BVA' , 2);


select * from signature where id in (select id from person);