create table account (
    id bigint primary key,
    number varchar(20) not null,
    balance decimal(10,2) not null,
    type smallint not null,
    status smallint not null,
    customer int not null,
    active boolean not null
);