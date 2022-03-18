CREATE TABLE IF NOT EXISTS user_ordered_payment (
	id integer NOT NULL PRIMARY KEY,
	user_order_id integer NOT NULL, 
	cart_value double NOT NULL, 
	ship_value double NOT NULL, 
	tax_value double NOT NULL,
	payment_method varchar(50) NOT NULL
);