
create table if not exists publisher(
	id integer not null,
	name varchar(40),
	city varchar(50),
	CONSTRAINT publisher_pkey primary key(id)
);

create table if not exists books(
	id integer not null,
	name_book varchar(255),
	genre varchar(20),
	year integer,
	publisher_id integer references publisher(id),
	CONSTRAINT books_bkey primary key(id)
);

insert into publisher(id, name, city) values (1, 'Mojang', 'London');
insert into publisher(id, name, city) values (2, 'Fraktura', 'Munchen');
insert into publisher(id, name, city) values (3, 'Fisher Verlag', 'Keln');

insert into books(id, name_book, genre, year, publisher_id) values (1, 'Нейромант', 'cyberpunk', 2009, 1);
insert into books(id, name_book, genre, year, publisher_id) values (2, 'Лабиринт отражений', 'cyberpunk', 2010, 1);
insert into books(id, name_book, genre, year, publisher_id) values (3, 'Схизматрица','cyberpunk', 2008, 2);
insert into books(id, name_book, genre, year, publisher_id) values (4, 'Лавина (роман)', 'cyberpunk', 2007, 2);
insert into books(id, name_book, genre, year, publisher_id) values 
(5, 'Видоизменённый углерод Ричард Морган', 'cyberpunk', 2011, 1);
insert into books(id, name_book, genre, year, publisher_id) values (6, 'Алмазный век', 'cyberpunk', '2018', 2);
insert into books(id, name_book, genre, year, publisher_id) values (7, 'Фальшивые зеркала', 'cyberpunk', '2015', 2);
insert into books(id, name_book, genre, year, publisher_id) values (8, 'Московский клуб', 'cyberpunk', '2005', 1);
insert into books(id, name_book, genre, year, publisher_id) values (9, 'Дзен-софт Aleksei Vert', 'cyberpunk', 2009, 1);
insert into books(id, name_book, genre, year, publisher_id) values (10, 'Слияние', 'tech', 2010, 1);
insert into books(id, name_book, genre, year, publisher_id) values (11, 'Река моих сожалений', 'tech', 2011, 1);
insert into books(id, name_book, genre, year, publisher_id) values (12, 'Блэкаут', 'tech', 2000, 3);
insert into books(id, name_book, genre, year, publisher_id) values (13, 'Дверь в Лето', 'Science fiction', 1956, 1);
insert into books(id, name_book, genre, year, publisher_id) values (14, 'Звёздный десант', 'Science fiction', 1959, 1);
insert into books(id, name_book, genre, year, publisher_id) values 
(15, 'Чужак в чужой стране', 'Science fiction', 1961, 1);

select name_book as Название_книг, name as Издательства from books as b join publisher as p on b.publisher_id = p.id
where year > 2009 and year < 2018 and b.genre ='tech' or b.genre = 'cyberpunk'

