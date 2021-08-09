create table students (
	id serial primary key,
	student varchar(255)
);
create table subjects (
	id serial primary key,
	subject varchar(255)
);

create table students_subjects (
	id serial primary key,
	mark int,
	students_id int references students (id),
	subjects_id int references subjects (id)
);

insert into students (student) values ('Vasya'), ('Annya'), ('Borya');
insert into subjects (subject) values ('Computer Science'), ('History'), ('Russian Language');

insert into students_subjects (students_id, subjects_id, mark) values (1, 1, 5), (1, 2, 4), (1, 3, 5);
insert into students_subjects (students_id, subjects_id, mark) values (2, 1, 4), (2, 2, 5), (2, 3, 5);
insert into students_subjects (students_id, subjects_id, mark) values (3, 1, 3), (3, 2, 4), (3, 3, 3);

select avg (mark) from students_subjects;
select min (mark) from students_subjects;
select max (mark) from students_subjects;

--select s.subject, avg(ss.mark) from students_subjects as ss join subjects as s on ss.subjects_id = s.id
--group by s.subject;

select s.student, avg(ss.mark) from students_subjects as ss join students as s on ss.students_id = s.id
group by s.student;

--select s.subject, avg(ss.mark) from students_subjects as ss join subjects as s on ss.subjects_id = s.id 
--group by s.subject
--having avg(ss.mark) > 4.5;