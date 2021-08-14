DROP TABLE IF EXISTS access;

CREATE TABLE IF NOT EXISTS access (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	description varchar(500) NULL
);

INSERT INTO access (id, name) VALUES (1, 'ADMIN');
INSERT INTO access (id, name) VALUES (2, 'USER');
