DROP SCHEMA game;
CREATE SCHEMA game;
USE game;

CREATE TABLE game (
id BIGINT AUTO_INCREMENT,
name VARCHAR(255),
master_id BIGINT,
PRIMARY KEY(id)
);

CREATE TABLE user_id(
id BIGINT,
PRIMARY KEY(id)
);

CREATE TABLE game_has_user_list(
game_id BIGINT,
user_id BIGINT,
PRIMARY KEY(game_id, user_id),
FOREIGN KEY(game_id) REFERENCES game(id),
FOREIGN KEY(user_id) REFERENCES user_id(id)
);

INSERT INTO game (name, master_id) VALUES 
('La partida de TartKross', 1),
('La partida de Taro Korosu', 1),
('La partida de España', 2);

INSERT INTO user_id (id) VALUES
(1),
(2),
(3),
(4),
(5);

INSERT INTO game_has_user_list (game_id, user_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(3, 1),
(3, 5);

SELECT * FROM game;

SELECT DISTINCT name, master_id FROM game g 
			  JOIN game_has_user_list user_list ON g.id = user_list.game_id
              WHERE user_list.user_id = 1;