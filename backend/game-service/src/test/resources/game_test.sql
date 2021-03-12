DROP SCHEMA game_test;
CREATE SCHEMA game_test;
USE game_test;

CREATE TABLE game (
id BIGINT AUTO_INCREMENT,
name VARCHAR(255),
master_id BIGINT,
token varchar(255),
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



