delete from account
where id in (select account_id from partner);

delete from client
where partner_id in (select id from partner);

delete from partner;