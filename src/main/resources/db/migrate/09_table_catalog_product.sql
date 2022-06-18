CREATE TABLE IF NOT EXISTS catalog_product (
	id integer NOT NULL PRIMARY KEY,
	catalog_id integer NOT NULL, 
	product_id integer NOT NULL, 
	price double NOT NULL, 
	quantity double NOT NULL
);
