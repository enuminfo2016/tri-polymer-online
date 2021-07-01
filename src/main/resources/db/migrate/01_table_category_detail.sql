DROP TABLE IF EXISTS category_detail;

CREATE TABLE IF NOT EXISTS category_detail (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	description varchar(500) NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO category_detail (id, name) VALUES (1, 'Medical Component');
INSERT INTO category_detail (id, name) VALUES (2, 'Water Component');
