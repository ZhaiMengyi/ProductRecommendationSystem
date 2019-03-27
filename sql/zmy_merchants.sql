create table merchants
(
  mer_id       int auto_increment
    primary key,
  mer_username varchar(20)   not null,
  mer_password varchar(20)   not null,
  mer_shopName varchar(20)   not null,
  mer_mobile   varchar(20)   not null,
  mer_address  varchar(50)   not null,
  mer_status   int default 0 null,
  constraint merchants_mer_username_uindex
    unique (mer_username)
);

INSERT INTO zmy.merchants (mer_id, mer_username, mer_password, mer_shopName, mer_mobile, mer_address, mer_status) VALUES (1, 'm1', '970811', 'Cherry', '15911111111', '四川省成都市', 1);
INSERT INTO zmy.merchants (mer_id, mer_username, mer_password, mer_shopName, mer_mobile, mer_address, mer_status) VALUES (2, 'chenrui', 'asdasda', 'Dell', '15922222222', '四川省德阳市', 0);