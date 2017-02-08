drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

create table MONKEYS(
   ID bigint not null,
   NAME varchar(15),
   primary key (ID)
);

create table TEACHERS(
  ID bigint not null,
  NAME varchar(15),
  primary key(ID)
);

create table LEARNING(
  ID bigint not null,
  MONKEY_ID bigint not null,
  TEACHER_ID bigint not null,
  GONGFU varchar(15),
  primary key(ID)
);

alter table LEARNING add index IDX_MONKEY(MONKEY_ID), 
add constraint FK_MONKEY foreign key (MONKEY_ID) references MONKEYS(ID);

alter table LEARNING add index IDX_TEACHER(TEACHER_ID), 
add constraint FK_TEACHER foreign key (TEACHER_ID) references TEACHERS(ID);
