-- 1. Вывести всех покупателей
SELECT * FROM customer;

-- 2. Вывести все заказы с именем покупателя и описанием товара
SELECT o.id, c.full_name, p.description, o.quantity, o.order_date
FROM orders o
JOIN customer c ON o.customer_id = c.id
JOIN product p ON o.product_id = p.id;

-- 3. Изменить количество товара
UPDATE product SET quantity = quantity - 1 WHERE id = 1;

-- 4. Изменить фамилию покупателя
UPDATE customer SET full_name = 'Иван Петров-Сидоров' WHERE id = 1;

-- 5. Удалить заказ
DELETE FROM orders WHERE id = 10;

-- 6. Удалить покупателя без заказов
DELETE FROM customer WHERE id NOT IN (SELECT DISTINCT customer_id FROM orders);

-- 7. Посчитать общее количество заказанных товаров
SELECT SUM(quantity) AS total_items FROM orders;

-- 8. Показать товары, которых меньше 10 на складе
SELECT * FROM product WHERE quantity < 10;

-- 9. Добавить новый заказ
INSERT INTO orders (product_id, customer_id, quantity) VALUES (3, 2, 5);

-- 10. Посчитать выручку по каждому товару
SELECT p.description, SUM(p.price * o.quantity) AS total_income
FROM orders o
JOIN product p ON o.product_id = p.id
GROUP BY p.description;
