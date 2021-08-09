create table type (
	id serial primary key,
	type varchar(255)
);

create table product(
	id serial primary key, 
	name_product varchar(255),
	type_id int references type(id), 
	expired_date date, 
	price float
);

insert into type (type) values ('Сыр'), ('Молоко'), ('Фрукты'), ('Мороженное');

insert into product (type_id, name_product, price, expired_date) values
(1, 'Тофу', 536.99, '12.12.2022'),
(1, 'Рикотта', 427.99, '29.08.2022'), 
(1, 'СЫР МОЦАРЕЛЛА', 120.99, '05.11.2021'),
(1, 'Филадельфия', 601.99, '05.08.2021');

insert into product (type_id, name_product, price, expired_date) values 
(2, 'Коровье молоко', 94.99, '08.08.2021'),
(2, 'Козье молоко', 1590.99, '02.09.2021'),
(2, 'Сливки', 125.99, '30.07.2021');

insert into product (type_id, name_product, price, expired_date) values 
(3, 'Apple(fruit)', 47.99, '13.10.2021'),
(3, 'Cherry(fruit)', 74.99, '13.10.2021'),
(3, 'Banan(fruit)', 81.99, '13.10.2021'),
(3, 'Avakado(fruit)', 540.99, '13.10.2021'),
(3, 'Orange(fruit)', 61.99, '13.10.2021'),
(3, 'Melon(fruit)', 220.99, '13.10.2021');

insert into product (type_id, name_product, price, expired_date) values
(4, 'Мороженное ЭКЗО', 120.99, '31.12.2022'),
(4, 'Мороженное МАГНАТ', 145.99,'31.12.2022'),
(4, 'Мороженное Эскимо', 85.99, '31.12.2022'),
(4, 'Золотой Стандарт', 45.99, '31.12.2022');

select t.type as Тип_продуктов, name_product as Наименование, price as Цена, expired_date as Срок_Хранения
from product as p inner join type as t on p.type_id = t.id
and t.type = 'Сыр';

select t.type as name, price price, expired_date date, type_id as type from product as p join type as t on p.type_id =t.id
where name_product like 'Мороженное';

