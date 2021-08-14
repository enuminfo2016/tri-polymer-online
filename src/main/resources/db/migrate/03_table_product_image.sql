DROP TABLE IF EXISTS product_image;

CREATE TABLE IF NOT EXISTS product_image (
	id integer NOT NULL PRIMARY KEY,
	product_id integer NOT NULL,
	img_name varchar(50) NOT NULL,
	img_type varchar(25) NOT NULL,
	img_data blob NOT NULL
);