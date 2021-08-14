DROP TABLE IF EXISTS location;

CREATE TABLE IF NOT EXISTS location (
	id integer NOT NULL PRIMARY KEY,
    name varchar(50) NOT NULL,
    pin bigint NOT NULL,
    city varchar(50) NOT NULL,
    state varchar(50) NOT NULL,
	country integer NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);