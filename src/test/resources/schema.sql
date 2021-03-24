-- drop database if exists countries_db;
-- create database if not exists countries_db;

drop table if exists pais;

create table if not exists pais(id int auto_increment primary key,
nome varchar(500) not null unique,
capital varchar(500) not null,
regiao varchar(500),
sub_regiao varchar(500),
area numeric(18, 2));

insert into pais(nome, capital, regiao, sub_regiao, area) values('Mozambique', 'Maputo', 'Africa', 'Africa Austral', 801510.00);
insert into pais(nome, capital, regiao, sub_regiao, area) values('Angola', 'Luanda', 'Africa', 'Africa Austral', 1246700.00);
insert into pais(nome, capital, regiao, sub_regiao, area) values('Africa do Sul', 'Pretoria', 'Africa', 'Africa Austral', 1221037.00);

