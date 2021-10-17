CREATE TABLE dependent(
	id SERIAL PRIMARY KEY,
	client_id integer REFERENCES client (id),
	name VARCHAR
);