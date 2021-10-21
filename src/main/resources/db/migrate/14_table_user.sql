DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
	id integer NOT NULL PRIMARY KEY,
	username varchar(50) NOT NULL,
	password varchar(10) NOT NULL,
	access varchar(50) NOT NULL
);
