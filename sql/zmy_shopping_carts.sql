create table shopping_carts
(
  cart_id int auto_increment
    primary key,
  user_id int not null,
  pro_id  int not null,
  pro_num int not null,
  constraint shopping_carts_ibfk_1
    foreign key (user_id) references users (user_id),
  constraint shopping_carts_ibfk_2
    foreign key (pro_id) references products (pro_id)
);

create index pro_id
  on shopping_carts (pro_id);

create index user_id
  on shopping_carts (user_id);

INSERT INTO zmy.shopping_carts (cart_id, user_id, pro_id, pro_num) VALUES (2, 1, 1, 100);
INSERT INTO zmy.shopping_carts (cart_id, user_id, pro_id, pro_num) VALUES (3, 1, 1, 5);
INSERT INTO zmy.shopping_carts (cart_id, user_id, pro_id, pro_num) VALUES (4, 1, 1, 2);