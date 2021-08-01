create table teens (
	id serial primary key,
	name text,
	gender text
);

insert into teens (name, gender) values ('Veronika', 'female');
insert into teens (name, gender) values ('Roman', 'male');

select t1.name, t1.gender, t2.name, t2.gender from teens as t1 cross join teens as t2 where t1.gender != t2.gender;