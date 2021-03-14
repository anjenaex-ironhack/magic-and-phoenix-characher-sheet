drop schema users_from_magic_and_phoenix_app;
create schema users_from_magic_and_phoenix_app;
use users_from_magic_and_phoenix_app;

create table users_table (
id bigint AUTO_INCREMENT,
name varchar(255),
email varchar(255),
password varchar(255),
role varchar(255),
PRIMARY KEY(id)
);

insert into users_table (name, email, password, role) values 
('Antonio', 'anjenaex@gmail.com', '1234567', 'ROLE_USER'),
('Romualdo', 'romualdo@gmail.com', '1234457', 'ROLE_USER'),
('Elif', 'elif@gmail.com', '1234567', 'ROLE_USER'),
('Villacañas', 'villa@gmail.com', '1234567', 'ROLE_USER'),
('Nacho', 'nachuatadawi@hotmail.com', '1234567', 'ROLE_USER'),
('Juan', 'juanherrador@hotmail.com', '1234567', 'ROLE_USER');
