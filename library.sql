create table author (
	id serial primary key,
	name varchar(255)
);

create table books (
	id serial primary key,
	name varchar(255),
	author_id int references author(id) unique
);

create table shelves (
	id serial primary key,
	name varchar(255),
	books_id int references books(id)
);

insert into author (name) values ('Sanya');
insert into author (name) values ('Lev Tolstoy');
insert into author (name) values ('Alexsey');
insert into author (name) values ('Roman');

insert into books (name, author_id) values ('War and Peace', 2);
insert into books (name, author_id) values ('Gone Girl', 1);
insert into books (name, author_id) values ('The Door into Summer', 3);
insert into books (name, author_id) values ('Harry Potter', 4);
insert into books (name) values ('Adventure Time');

insert into shelves (name, books_id) values ('A1', 1);
insert into shelves (name, books_id) values ('A1', 2);
insert into shelves (name, books_id) values ('A1', 3);
insert into shelves (name, books_id) values ('A1', 4);
insert into shelves (name, books_id) values ('A2', 5);

select ss.name as Полка, b.name as Книги, b.author_id as Автор 
from shelves as ss join books as b on ss.books_id = b.id;

select bk.name as Книги, a.name as Автор 
from books as bk join author as a on bk.author_id = a.id;

select a.name as Автор, b.name Книги
from author as a join books as b on b.author_id = a.id and a.name = 'Lev Tolstoy';
