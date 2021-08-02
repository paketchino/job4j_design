

select t.type as Тип_продуктов, name_product as Наименование, price as Цена, expired_date as Срок_Хранения
from product as p inner join type as t on p.type_id = t.id
and t.type = 'Сыр';

select t.type as Тип_продуктов, name_product as Наименование, price as Цена, expired_date as Срок_Хранения
from product as p inner join type as t on p.type_id = t.id
where name_product like '%Мороженное%';

select t.type as Тип_продуктов, count(t.type) as Количество
from product as p inner join type as t on p.type_id = t.id group by t.type;

select t.type as Тип_продуктов, name_product as Наименование
from product as p join type as t on p.type_id = t.id where t.type = 'Сыр' or t.type = 'Молоко';

select t.type as Тип_продуктов, count(t.type) as Количество
from product as p join type as t on p.type_id = t.id
group by t.type
having count(t.type) < 4;

select t.type as Тип_продуктов, name_product as Наименование, price as Цена, expired_date as Срок_Хранения
from product as p inner join type as t on p.type_id = t.id;

select t.type as Тип_продуктов, name_product as Наименование, price as Цена, expired_date as Срок_Хранения
from product as p inner join type as t on p.type_id = t.id 
where expired_date < current_date;

--select max(price) from product;
select * from product where price = (select max(price) from product);
