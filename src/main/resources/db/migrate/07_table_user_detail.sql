CREATE TABLE IF NOT EXISTS user (
	id integer NOT NULL PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	middle_name varchar(50) NULL,
	last_name varchar(50) NOT NULL,
	email_address varchar(50) NOT NULL,
	phone_number bigint NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);