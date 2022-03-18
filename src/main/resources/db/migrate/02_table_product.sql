CREATE TABLE IF NOT EXISTS product (
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

INSERT INTO product (id, name, category_id) VALUES  (1, 'Medical Tubes', 1);
INSERT INTO product (id, name, category_id) VALUES  (2, 'Medical Urine', 1);
INSERT INTO product (id, name, category_id) VALUES  (3, 'One Ltr Customized', 2);
INSERT INTO product (id, name, category_id) VALUES  (4, 'Half Ltr Customized', 2);
INSERT INTO product (id, name, category_id) VALUES  (5, 'Thread Cap', 2);
