create table user_orders
(
  ord_id      int auto_increment
    primary key,
  user_id     int           not null,
  pro_id      int           not null,
  ord_time    varchar(50)   not null,
  ord_address varchar(50)   not null,
  ord_status  int default 0 null,
  constraint user_orders_ibfk_1
    foreign key (user_id) references users (user_id),
  constraint user_orders_ibfk_2
    foreign key (pro_id) references products (pro_id)
);

create index pro_id
  on user_orders (pro_id);

create index user_id
  on user_orders (user_id);

INSERT INTO zmy.user_orders (ord_id, user_id, pro_id, ord_time, ord_address, ord_status) VALUES (1, 1, 1, '2019-03-10-17-24-48', 'chengdu', -1);
INSERT INTO zmy.user_orders (ord_id, user_id, pro_id, ord_time, ord_address, ord_status) VALUES (2, 1, 2, '2019-03-10-17-25-09', 'shangdong', 1);
INSERT INTO zmy.user_orders (ord_id, user_id, pro_id, ord_time, ord_address, ord_status) VALUES (3, 1, 2, '2019-03-27-11-33-49', '四川省成都市高新西区百叶路一号', 0);
INSERT INTO zmy.user_orders (ord_id, user_id, pro_id, ord_time, ord_address, ord_status) VALUES (4, 1, 2, '2019-03-27-11-41-00', '四川省成都市高新西区百叶路一号', 0);