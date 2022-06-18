CREATE TABLE IF NOT EXISTS catalog (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);
