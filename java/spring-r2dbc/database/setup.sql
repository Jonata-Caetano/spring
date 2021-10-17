--------------------------------------------------------
--  Create client table
--------------------------------------------------------
CREATE TABLE public.client (
	id int4 PRIMARY KEY,
	name varchar(40) NOT NULL
);

CREATE TABLE public.client_dependent (
	id int4 PRIMARY KEY,
	client_id int4 NOT NULL,
	name varchar(40) NOT NULL,
	CONSTRAINT client_id_fk FOREIGN KEY (client_id)
	REFERENCES client (id)
);

insert into public.client
values (1, 'Tiago');

insert into public.client_dependent
values (1, 1, 'Valentina');

insert into public.client_dependent
values (2, 1, 'Nicolas');