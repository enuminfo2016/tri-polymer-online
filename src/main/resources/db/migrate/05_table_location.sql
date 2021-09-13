DROP TABLE IF EXISTS location;

CREATE TABLE IF NOT EXISTS location (
	id integer NOT NULL PRIMARY KEY,
    name varchar(50) NOT NULL,
    pin bigint NOT NULL,
    city varchar(50) NOT NULL,
    state varchar(50) NOT NULL,
	country_id integer NOT NULL,
	status boolean DEFAULT true,
	created_by varchar(25) DEFAULT 'Online',
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_by varchar(25) DEFAULT 'Online',
	updated_on timestamp DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO location (id, name, pin, city, state, country_id) VALUES (10821, 'Adugodi', 560030, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (10912, 'Anand Nagar', 560024, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (10970, 'Ashok Nagar', 560050, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (10986, 'Attibele', 562107, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (10993, 'Austin Town', 560047, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11084, 'Banashankari', 560050, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11087, 'Banaswadi', 560043, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11112, 'Bannerghatta', 560083, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11251, 'Benson Town', 560046, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11373, 'Bommasandra', 562158, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11414, 'Carmelaram', 560035, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11444, 'Chandpura', 562145, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11471, 'Chickpet', 560053, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11478, 'Chikballapur', 562101, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11548, 'Cubbon Road', 560001, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11549, 'Cunningham', 560052, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11592, 'Devanahalli', 562110, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11653, 'Domlur', 560071, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11654, 'Dommasandra', 562148, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11659, 'Doorvaninagar', 560016, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11684, 'Fraser Town', 560005, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (11953, 'Hebbal', 560024, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12109, 'Hosur Road', 560030, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12189, 'Indira Nagar', 560038, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12224, 'Jalahalli', 560013, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12253, 'Jayanagar', 560011, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12266, 'Jeevanbheemanagar', 560075, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12320, 'Kadugodi', 560067, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12378, 'Kamagondanahalli', 560015, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12499, 'Kempegowda', 560009, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12551, 'Kodihalli', 562119, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12654, 'Krisnarajapuram', 560036, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12763, 'Lingarajapuram', 560084, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12797, 'Madivala', 560058, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12835, 'Malleswaram', 560003, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (12919, 'Marathahalli', 560037, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13095, 'Nagarbhavi', 560072, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13166, 'Neelasandra', 560047, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13179, 'Nelamangala', 562123, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13248, 'Padmanabhanagar', 560070, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13342, 'Rajajinagar', 560010, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13405, 'Residency Road', 560025, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13407, 'Richmond Town', 560025, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13854, 'Ulsoor', 560008, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13882, 'Varthur', 560087, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13885, 'Vasantanagar', 560052, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (13930, 'Whitefield', 560066, 'Bangalore', 'Karnataka', 99);
INSERT INTO location (id, name, pin, city, state, country_id) VALUES (14006, 'Yeshwantpur', 560022, 'Bangalore', 'Karnataka', 99);