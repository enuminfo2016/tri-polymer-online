DROP TABLE IF EXISTS product_detail

CREATE TABLE IF NOT EXISTS product_detail (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	description varchar(500) NULL,
	category_id integer NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO product_detail (id, name, description, category_id) VALUES  (1, 'Blood Testtube', 'I am blood test tube!!!', 1);
INSERT INTO product_detail (id, name, description, category_id) VALUES  (2, 'Urine Testtube', 'I am urine test tube!!!', 1);
INSERT INTO product_detail (id, name, description, category_id) VALUES  (3, '1L Bottle', 'I am one litre bottle!!!', 2);
INSERT INTO product_detail (id, name, description, category_id) VALUES  (4, '20L Bottle', 'I am 20 litre bottle!!!', 2);
