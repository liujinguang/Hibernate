drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

create table MONKEYS (
   ID bigint not null,
   NAME varchar(15),
   AGE int, 
   primary key (ID)
);

create table IMAGES(
   ID bigint not null,
   MONKEY_ID bigint not null,
   FILENAME varchar(15) not null,
   primary key (ID)
);

alter table IMAGES add index IDX_MONKEY(MONKEY_ID), add constraint FK_MONKEY foreign key (MONKEY_ID) references MONKEYS(ID);

