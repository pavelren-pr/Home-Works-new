CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customer(id),
    order_date DATE NOT NULL,
    total_orders INT DEFAULT 0,
    discount NUMERIC(5,2) DEFAULT 0.00
);
