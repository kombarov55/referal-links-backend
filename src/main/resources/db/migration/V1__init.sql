create table account
(
    id varchar primary key,
    login varchar unique,
    pwd_hash varchar,
    role varchar
);

create table partner
(
    id varchar primary key,
    account_id varchar not null,
    points int default 0
);

