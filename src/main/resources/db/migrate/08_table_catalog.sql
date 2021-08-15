DROP TABLE IF EXISTS catalog;

CREATE TABLE IF NOT EXISTS catalog (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	start_date varchar(25) NOT NULL,
	end_date varchar(25) NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO catalog (id, name, start_date, end_date) VALUES (1, '2021 Catalog', '2021-04-01', '2022-03-31');
