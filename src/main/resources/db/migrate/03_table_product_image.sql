DROP TABLE IF EXISTS product_image;

CREATE TABLE IF NOT EXISTS product_image (
	id integer NOT NULL PRIMARY KEY,
	product_id integer NOT NULL,
	img_name varchar(50) NOT NULL,
	img_type varchar(25) NOT NULL,
	img_data blob NULL,
	main_img boolean DEFAULT false
);

INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (1, 1, 'medical-tubes-1.png', 'png', 1);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (2, 1, 'medical-tubes-2.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (3, 1, 'medical-tubes-3.png', 'png', 0);

INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (4, 2, 'medical-urine-4.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (5, 2, 'medical-urine-5.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (6, 2, 'medical-urine-6.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (7, 2, 'medical-urine-7.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (8, 2, 'medical-urine-bottlle-2.png', 'png', 1);

INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (9, 3, '1-liter-customised-bottle-cap-1.png', 'png', 1);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (10, 3, '1-liter-customised-bottle-cap-2.png', 'png', 0);

INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (11, 4, 'half-liter-customized-cap-1.png', 'png', 1);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (12, 4, 'half-liter-customized-cap-2.png', 'png', 0);

INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (13, 5, 'thread-cap-2.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (14, 5, 'thread-cap-3.png', 'png', 0);
INSERT INTO product_image (id, product_id, img_name, img_type, main_img) VALUES  (15, 5, 'thread-cap-4.png', 'png', 1);
