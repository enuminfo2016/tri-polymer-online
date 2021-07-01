DROP TABLE IF EXISTS user_ordered_item_detail;

CREATE TABLE IF NOT EXISTS user_ordered_item_detail (
	id integer NOT NULL PRIMARY KEY,
	user_order_id integer NOT NULL, 
	product_id integer NOT NULL, 
	price double NOT NULL, 
	quantity double NOT NULL
);