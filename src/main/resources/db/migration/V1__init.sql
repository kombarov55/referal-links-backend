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

create table client
(
    id varchar primary key,
    account_id varchar not null,
    partner_id varchar not null,
    first_name varchar,
    last_name varchar,
    middle_name varchar,
    address varchar,
    post_index varchar,
    email varchar,
    phone varchar,
    country varchar
);

create table bonus_history
(
  id varchar primary key,
  partner_id varchar not null,
  diff int,
  amount int,
  creation_date timestamp
);
