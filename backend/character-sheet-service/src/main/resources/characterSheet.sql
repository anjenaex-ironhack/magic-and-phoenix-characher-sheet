drop schema character_sheet;
create schema character_sheet;
use character_sheet;

create table character_sheet(
id bigint AUTO_INCREMENT,
userId bigint,
gameId bigint,
name varchar(255),
racialLineage varchar(255),
country varchar (255),
profession varchar(255),
px int,
physical int,
skill int,
mental int,
social int,
athletics int,
knowledge int,
interpretation int, 
perception int, 
caution int, 
conjuration int,
PRIMARY KEY(id)
);