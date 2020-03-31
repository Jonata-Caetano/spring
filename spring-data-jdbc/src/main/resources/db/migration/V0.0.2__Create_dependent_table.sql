CREATE TABLE dependent(
	id SERIAL PRIMARY KEY,
	client integer REFERENCES client (id),
	name VARCHAR
);