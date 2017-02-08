drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

drop table if exists  MONKEYS ;
create table MONKEYS(
   ID bigint not null,
   NAME varchar(15),
   COUNT int,
   primary key (ID) 
);


insert into MONKEYS(ID,NAME,COUNT) values(1,'智多星',1000);
