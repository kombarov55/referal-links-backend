alter table client add column fio varchar;

update client set fio = last_name || ' ' || first_name;

alter table client drop column first_name;
alter table client drop column last_name;
alter table client drop column middle_name;
alter table client drop column account_id;
