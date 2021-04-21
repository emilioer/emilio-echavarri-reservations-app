drop table if exists reservations;

create table reservations (
	id integer not null,
	name varchar(100) not null,
	time varchar(30) not null,
	primary key(id)
);

