create table movement
(
    id      bigint primary key,
    date    timestamp      not null,
    amount  decimal(10, 2) not null,
    balance decimal(10, 2) not null,
    type    smallint       not null,
    account bigint         not null
);

create sequence movement_seq
    start with 1
    increment by 50
    cycle;