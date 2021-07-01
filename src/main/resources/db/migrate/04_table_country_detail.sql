DROP TABLE IF EXISTS country_detail;

CREATE TABLE IF NOT EXISTS country_detail (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL, 
	iso varchar(20) NOT NULL, 
	isd varchar(20) NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);