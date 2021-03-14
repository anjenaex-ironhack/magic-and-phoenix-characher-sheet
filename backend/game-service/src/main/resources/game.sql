DROP SCHEMA game;
CREATE SCHEMA game;
USE game;

CREATE TABLE game (
id BIGINT AUTO_INCREMENT,
name VARCHAR(255),
master_id BIGINT,
token VARCHAR(255),
PRIMARY KEY(id)
);

CREATE TABLE user_id(
id BIGINT,
PRIMARY KEY(id)
);

CREATE TABLE game_has_user_list(
game_id BIGINT,
user_id BIGINT,
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