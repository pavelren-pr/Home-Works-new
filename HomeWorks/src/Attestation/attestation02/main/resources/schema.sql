-- Таблица "Товар"
CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    quantity INT NOT NULL
);
COMMENT ON TABLE product IS 'Таблица товаров магазина';

-- Таблица "Покупатель"
CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL
);
COMMENT ON TABLE customer IS 'Таблица покупателей';

-- Таблица "Заказ"
CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    product_id INT REFERENCES product(id),
    customer_id INT REFERENCES customer(id),
    order_date DATE DEFAULT CURRENT_DATE,
    quantity INT NOT NULL
);

COMMENT ON TABLE orders IS 'Таблица заказов с указанием покупателя и товара';

-- Заполнение таблиц
INSERT INTO product (description, price, quantity)
VALUES
('Ноутбук Lenovo', 82000, 10),
('Смартфон Samsung', 56000, 20),
('Монитор LG', 19000, 15),
('Наушники Sony', 7000, 50),
('Клавиатура Logitech', 4500, 25),
('Мышь Razer', 5500, 30),
('Принтер HP', 22000, 5),
('Телевизор Philips', 67000, 8),
('Флешка Kingston 64GB', 1200, 40),
('SSD Samsung 1TB', 9800, 12);

INSERT INTO customer (full_name)
VALUES
('Иван Петров'),
('Мария Смирнова'),
('Сергей Иванов'),
('Ольга Кузнецова'),
('Павел Орлов'),
('Елена Соколова'),
('Дмитрий Волков'),
('Анна Сергеева'),
('Алексей Никитин'),
('Наталья Васильева');

INSERT INTO orders (product_id, customer_id, quantity)
VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 1),
(4, 4, 3),
(5, 5, 2),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 4),
(10, 10, 2);
