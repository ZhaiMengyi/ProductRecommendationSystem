create table products
(
  pro_id        int auto_increment
    primary key,
  pro_name      varchar(20) not null,
  pro_price     double      not null,
  pro_inventory int         not null,
  mer_id        int         not null,
  constraint products_ibfk_1
    foreign key (mer_id) references merchants (mer_id)
      on update cascade on delete cascade
);

create index mer_id
  on products (mer_id);

INSERT INTO zmy.products (pro_id, pro_name, pro_price, pro_inventory, mer_id) VALUES (1, 'cola', 3, 999, 1);
INSERT INTO zmy.products (pro_id, pro_name, pro_price, pro_inventory, mer_id) VALUES (2, 'mouse', 200, 999, 1);