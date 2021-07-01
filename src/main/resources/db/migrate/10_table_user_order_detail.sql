DROP TABLE IF EXISTS user_order_detail;

CREATE TABLE IF NOT EXISTS user_order_detail (
	id integer NOT NULL PRIMARY KEY,
	user_id integer NOT NULL, 
	status varchar(20) NULL,
	delivery_status varchar(20) NULL,
	drafted_date timestamp NULL,
	ordered_date timestamp NULL,
	cancelled_date timestamp NULL
);