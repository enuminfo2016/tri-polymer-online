DROP TABLE IF EXISTS user_order;

CREATE TABLE IF NOT EXISTS user_order (
	id integer NOT NULL PRIMARY KEY,
	user_id integer NOT NULL, 
	status varchar(20) NULL,
	delivery_status varchar(20) NULL,
	drafted_date date NULL,
	ordered_date date NULL,
	cancelled_date date NULL
);