
CREATE table IF NOT EXISTS customer(
	id INT NOT NULL,
	name VARCHAR(50) NOT NULL
);
TRUNCATE TABLE customer RESTART IDENTITY;

INSERT INTO customer (id, name) VALUES (1, 'Eric');
INSERT INTO customer (id, name) VALUES (2, 'Stan');
INSERT INTO customer (id, name) VALUES (3, 'Kyle');
INSERT INTO customer (id, name) VALUES (4, 'Kenny');
INSERT INTO customer (id, name) VALUES (5, 'Heidi');


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
	order_time TIME NOT NULL,
	bonus TINYINT
);

TRUNCATE TABLE customer_package_order RESTART IDENTITY;
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (1, 1, 1, '10:05:10', false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (2, 2, 1, '10:10:15', false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (3, 3, 1, '10:20:20', false);

INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (4, 4, 2, '11:05:10', false);

INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (5, 5, 1, '12:00:00', false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (6, 1, 3, '12:30:00', false);

INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (7, 2, 2, '13:00:00', false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (8, 3, 1, '13:30:00', false);
INSERT INTO customer_package_order (id, customer_id, package_id, order_time, bonus) VALUES (9, 4, 2, '13:30:00', false);

