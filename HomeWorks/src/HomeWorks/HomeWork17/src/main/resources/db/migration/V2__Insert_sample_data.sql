INSERT INTO customer (first_name, last_name)
VALUES ('Иван', 'Иванов'), ('Петр', 'Петров');

INSERT INTO orders (customer_id, order_date, total_orders, discount)
VALUES
(1, CURRENT_DATE, 3, 10.00),
(2, CURRENT_DATE, 5, 15.00);
