drop table user if exists;
create table user(id int NOT NULL, firstname varchar(255), lastname varchar(255), username varchar(255), password varchar(255), salary int, age int,PRIMARY KEY (id));
INSERT INTO user(id, firstname, lastname, username, password, salary, age) VALUES (6, 'Alex','Knr', 'alex123','$2a$04$4vwa/ugGbBVDvbWaKUVZBuJbjyQyj6tqntjSmG8q.hi97.xSdhj/2', 3456, 33);
INSERT INTO user(id, firstname, lastname, username, password, salary, age)  VALUES (4, 'Tom', 'Asr', 'tom234', '$2a$04$QED4arFwM1AtQWkR3JkQx.hXxeAk/G45NiRd3Q4ElgZdzGYCYKZOW', 7823, 23);
INSERT INTO user(id, firstname, lastname, username, password, salary, age)  VALUES (5, 'Adam', 'Psr', 'adam', '$2a$04$WeT1SvJaGjmvQj34QG8VgO9qdXecKOYKEDZtCPeeIBSTxxEhazNla', 4234, 45);