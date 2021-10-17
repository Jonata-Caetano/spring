create table rental (
    id serial primary key,
    movie integer references movie(id),
    duration text,
    price integer
);