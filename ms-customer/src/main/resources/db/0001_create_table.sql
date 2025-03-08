create table customer (
	id int primary key,
	full_name varchar(100) not null,
	gender varchar(2) not null,
	age int not null,
	identification varchar(20) not null,
	address varchar(200) not null,
    phone varchar(20) not null,
	active boolean not null,
	client_id varchar(50) not null,
	password varchar(50) not null,
	status varchar(3) not null
);


