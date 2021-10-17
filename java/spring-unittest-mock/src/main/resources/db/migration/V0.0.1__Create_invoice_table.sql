CREATE TABLE invoice(
	id serial PRIMARY KEY,
	date_of_issue date,
	client_name varchar(100),
	value numeric(13,2)
);