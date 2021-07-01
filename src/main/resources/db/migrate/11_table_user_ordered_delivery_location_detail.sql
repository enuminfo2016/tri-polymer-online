DROP TABLE IF EXISTS user_ordered_delivery_location_detail;

CREATE TABLE IF NOT EXISTS user_ordered_delivery_location_detail (
	id integer NOT NULL PRIMARY KEY,
	user_order_id integer NOT NULL, 
	delivery_location_id integer NOT NULL
);