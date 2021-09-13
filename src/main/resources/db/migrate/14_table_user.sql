DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
	id integer NOT NULL PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	middle_name varchar(50) NULL,
	last_name varchar(50) NOT NULL,
	email_address varchar(50) NOT NULL,
	phone_number bigint NULL,
	password varchar(10) NOT NULL,
	access varchar(50) NOT NULL
);

INSERT INTO user (id, first_name, last_name, email_address, phone_number, access, password) VALUES  (1, 'Raghu',  'CHOWDAREDDY', 'raghavareddy@gmail.com', 9686379363, 'USER', 'p@55w0rd');
INSERT INTO user (id, first_name, last_name, email_address, phone_number, access, password) VALUES  (2, 'Siva Kumar', 'AKURATI', 'sivaakurati@gmail.com', 8884730405, 'ADMIN', 'p@55w0rd');
