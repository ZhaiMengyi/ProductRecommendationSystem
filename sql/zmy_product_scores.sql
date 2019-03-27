create table product_scores
(
  score_id int auto_increment
    primary key,
  user_id  int    not null,
  score    double not null,
  pro_id   int    not null
);

INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (1, 1, 9.9, 1);
INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (2, 1, 9.7, 2);
INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (3, 2, 9.8, 1);
INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (4, 2, 9.8, 2);
INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (5, 3, 6, 2);
INSERT INTO zmy.product_scores (score_id, user_id, score, pro_id) VALUES (6, 1, 5, 1);