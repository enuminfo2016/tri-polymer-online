DROP TABLE IF EXISTS delivery_location_detail;

CREATE TABLE IF NOT EXISTS delivery_location_detail (
	id integer NOT NULL PRIMARY KEY,
	value_1 varchar(100) NOT NULL, 
	value_2 varchar(100) NOT NULL, 
	value_3 varchar(100) NOT NULL,
	location_id integer NOT NULL
);