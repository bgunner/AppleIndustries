
CREATE table IF NOT EXISTS photo_package(
	id INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	price float NOT NULL
);

TRUNCATE TABLE photo_package RESTART IDENTITY;
INSERT INTO photo_package (id, name, price) VALUES (1, 'prints', 5);
INSERT INTO photo_package (id, name, price) VALUES (2, 'panoramas', 7);
INSERT INTO photo_package (id, name, price) VALUES (3, 'strips', 5);


CREATE table IF NOT EXISTS customer_package_order(
	id INT NOT NULL ,
	customer_id INT NOT NULL,
	package_id INT NOT NULL,
	order_date DATE NOT NULL,
	order_time TIME NOT NULL,
	actual_price FLOAT NOT NULL,
	bonus TINYINT
);

TRUNCATE TABLE customer_package_order RESTART IDENTITY;
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (1, 1, 1, '2023-01-01', '10:05:10', 5, false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (2, 2, 2, '2023-01-01', '10:10:15', 7, false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (3, 3, 3, '2023-01-01', '10:20:20', 5, false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (4, 3, 2, '2023-01-01', '10:20:20', 0, true);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (5, 3, 3, '2023-01-01', '10:20:20', 0, true);

INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (6, 4, 2, '2023-02-01', '11:05:10', 7, false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (7, 5, 3, '2023-02-01', '11:05:10', 5, false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (8, 4, 1, '2023-02-01', '11:55:10', 0, true);
INSERT INTO customer_package_order (id, customer_id, package_id, order_date, order_time,actual_price, bonus) VALUES (9, 4, 3, '2023-02-01', '11:55:10', 0, true);


CREATE table IF NOT EXISTS tax_bills(
	id INT NOT NULL ,
	tax_month INT NOT NULL,
	tax_year INT NOT NULL,
	profit float NOT NULL,
	tax_amount float NOT NULL
);

TRUNCATE TABLE tax_bills RESTART IDENTITY;