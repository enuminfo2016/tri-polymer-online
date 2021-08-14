DROP TABLE IF EXISTS catalog_product;

CREATE TABLE IF NOT EXISTS catalog_product (
	id integer NOT NULL PRIMARY KEY,
	catalog_id integer NOT NULL, 
	product_id integer NOT NULL, 
	price double NOT NULL, 
	quantity double NOT NULL
);

INSERT INTO catalog_product (id, catalog_id, product_id, price, quantity) VALUES (1, 1, 1, 17.00, 34.00);
INSERT INTO catalog_product (id, catalog_id, product_id, price, quantity) VALUES (2, 1, 2, 22.00, 45.00);
INSERT INTO catalog_product (id, catalog_id, product_id, price, quantity) VALUES (3, 1, 3, 12.00, 56.00);
INSERT INTO catalog_product (id, catalog_id, product_id, price, quantity) VALUES (4, 1, 4, 18.00, 34.00);
