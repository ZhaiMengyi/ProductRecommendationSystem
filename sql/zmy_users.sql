create table users
(
  user_id       int auto_increment
    primary key,
  user_name     varchar(20)   not null,
  user_password varchar(20)   not null,
  user_mobile   varchar(20)   not null,
  user_address  varchar(50)   null,
  user_status   int default 0 null,
  constraint users_user_name_uindex
    unique (user_name)
);

INSERT INTO zmy.users (user_id, user_name, user_password, user_mobile, user_address, user_status) VALUES (1, 'testModify', 'asd123', '15933333333', '四川省成都市', 0);
INSERT INTO zmy.users (user_id, user_name, user_password, user_mobile, user_address, user_status) VALUES (2, 'cr', '123456', '12345678999', 'chengdu', 0);
INSERT INTO zmy.users (user_id, user_name, user_password, user_mobile, user_address, user_status) VALUES (5, 'asdasd', 'asd123', '15988888888', '四川省成都市', 1);