DROP TABLE IF EXISTS delivery_location;

CREATE TABLE IF NOT EXISTS delivery_location (
	id integer NOT NULL PRIMARY KEY,
	user_id integer NOT NULL, 
	value_1 varchar(100) NOT NULL, 
	value_2 varchar(100) NOT NULL, 
	value_3 varchar(100) NOT NULL,
	location_id integer NOT NULL
);