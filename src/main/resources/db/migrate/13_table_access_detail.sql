DROP TABLE IF EXISTS access_detail;

CREATE TABLE IF NOT EXISTS access_detail (
	id integer NOT NULL PRIMARY KEY,
	name varchar(50) NOT NULL,
	description varchar(500) NULL
);

INSERT INTO access_detail (id, name) VALUES (1, 'ADMIN');
INSERT INTO access_detail (id, name) VALUES (2, 'USER');
