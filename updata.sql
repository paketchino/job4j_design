
select * from emploess as e left join departments as d on e.departments_id = d.id;
select * from departments as d right join emploess as e on d.id = e.departments_id;

select * from emploess as e right join departments as d on d.id = e.departments_id;
select * from departments as d left join emploess as e on e.departments_id = d.id;