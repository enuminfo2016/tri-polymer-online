DROP TABLE IF EXISTS product_image_detail;

CREATE TABLE IF NOT EXISTS product_image_detail (
	id integer NOT NULL PRIMARY KEY,
	product_id integer NOT NULL,
	img_name varchar(25) NOT NULL
);