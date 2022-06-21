create table users (
    id bigint NOT NULL AUTO_INCREMENT ,
    name varchar(80) NOT NULL ,
    balance int,
    PRIMARY KEY (id)

);

create table user_transaction(
  id bigint AUTO_INCREMENT,
  user_id bigint,
  amount int,
  transaction_date timestamp,
  PRIMARY KEY (id),
 FOREIGN KEY (user_id) REFERENCES users(id)
);