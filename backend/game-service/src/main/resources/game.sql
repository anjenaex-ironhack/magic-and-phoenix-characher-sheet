drop schema game;
create schema game;
use game;

create table game (
id BIGINT AUTO_INCREMENT,
name varchar(255),
master_id bigint,
token varchar(255),
PRIMARY KEY(id)
);

create table user_id(
id BIGINT,
PRIMARY KEY(id)
);

create table game_has_user_list(
game_id bigint,
user_id bigint,
PRIMARY KEY(game_id, user_id)
);

-- insert into game (name, master_id, token) values 
-- ('La partida de TartKross', 6, 'ABC'),
-- ('La partida de Taro Korosu', 6, 'ABC'),
-- ('La partida de los samurais',1,'BDF'),
-- ('La partida de España', 4, 'ABC');

-- insert into user_id (id) values
-- -- Antonio
-- (1), 
-- -- Romualdo
-- (2),
-- -- Villa
-- (3),
-- -- Elif
-- (4),
-- -- Juan
-- (5),
-- -- Nacho
-- (6);

-- insert into game_has_user_list (game_id, user_id) values
-- (1, 1),
-- (1, 2),
-- (1, 3),
-- (1, 4),
-- (4, 1),
-- (4, 5);

-- select * from game;