CREATE TABLE IF NOT EXISTS user_ordered_delivery_location (
	id integer NOT NULL PRIMARY KEY,
	user_order_id integer NOT NULL, 
	delivery_location_id integer NOT NULL
);