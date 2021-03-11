drop schema game;
create schema game;
use game;

create table game (
id BIGINT AUTO_INCREMENT,
name varchar(255),
master_id bigint,
PRIMARY KEY(id)
);

create table user_id_list(
id BIGINT,
PRIMARY KEY(id)
);

create table game_has_user_list(
game_id bigint,
user_id bigint,
PRIMARY KEY(game_id, user_id)
);

insert into game (name, master_id) values 
('La partida de TartKross', 1),
('La partida de Taro Korosu', 1),
('La partida de España', 2);

insert into user_id_list (id) values
(1),
(2),
(3),
(4),
(5);

insert into game_has_user_list (game_id, user_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(3, 1),
(3, 5);