create table author (
	id serial primary key,
	name_author varchar(255)
);

create table books (
	id serial primary key,
	title varchar(255),
	author_id int references author(id) unique
);

create table visitor (
	id serial primary key,
	users varchar(255),
	books_id int references books (id) unique
);


insert into author (name_author) values ('Sanya');
insert into author (name_author) values ('Lev Tolstoy');
insert into author (name_author) values ('Alexsey');
insert into author (name_author) values ('Roman');

insert into books (title, author_id) values ('War and Peace', 2);
insert into books (title, author_id) values ('Gone Girl', 1);
insert into books (title, author_id) values ('The Door into Summer', 3);
insert into books (title, author_id) values ('Harry Potter', 4);
insert into books (title) values ('Adventure Time');

insert into visitor (users, books_id) values ('User #1', 1);
insert into visitor (users, books_id) values ('User #2', 1);
insert into visitor (users, books_id) values ('User #3', 3);
insert into visitor (users) values ('User #4');

select bk.title as Название, a.name_author as Автор 
from books as bk inner join author as a on bk.author_id = a.id;

select vs.users as Посетитель, bk.title as Название, bk.author_id as Автор
from visitor as vs inner join books as bk on vs.books_id = bk.id;

select a.name_author as Автор, b.title Книги
from author as a join books as b on b.author_id = a.id and a.name_author = 'Lev Tolstoy';