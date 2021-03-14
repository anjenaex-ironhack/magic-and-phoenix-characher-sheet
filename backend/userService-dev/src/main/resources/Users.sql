drop schema users_from_magic_and_phoenix_app;
create schema users_from_magic_and_phoenix_app;
use users_from_magic_and_phoenix_app;

create table users_table (
id bigint AUTO_INCREMENT,
username varchar(255),
email varchar(255),
password varchar(255),
PRIMARY KEY(id)
);

create table roles_table (
id bigint AUTO_INCREMENT,
name varchar(255),
PRIMARY KEY(id)
);

create table user_roles(
	user_id bigint,
    role_id bigint,
    PRIMARY KEY(user_id,role_id),
    FOREIGN KEY(user_id) REFERENCES users_table(id),
    FOREIGN KEY(role_id) REFERENCES roles_table(id)
);

insert into roles_table(name) VALUE
('ROLE_USER');

-- insert into users_table (username, email, password) values 
-- ('Antonio', 'anjenaex@gmail.com', '1234567'),
-- ('Romualdo', 'romualdo@gmail.com', '1234457'),
-- ('Elif', 'elif@gmail.com', '1234567'),
-- ('Villacañas', 'villa@gmail.com', '1234567'),
-- ('Nacho', 'nachuatadawi@hotmail.com', '1234567'),
-- ('Juan', 'juanherrador@hotmail.com', '1234567');

-- insert into user_roles (user_id, role_id) values 
-- (1,1),
-- (2,1),
-- (3,1),
-- (4,1),
-- (5,1),
-- (6,1);

-- select * from users_table;
-- select id from users_table where username = "antonio";



