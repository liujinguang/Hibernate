drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

create table MONKEYS (
   ID bigint not null,
   NAME varchar(15),
   primary key (ID)
);

create table ADDRESSES(
   ID bigint not null,
   STREET varchar(128),
   CITY varchar(128),
   PROVINCE varchar(128),
   ZIPCODE varchar(6),
   primary key (ID)
);

alter table ADDRESSES add index IDX_MONKEY(ID), add constraint FK_MONKEY foreign key (ID) references MONKEYS(ID);

