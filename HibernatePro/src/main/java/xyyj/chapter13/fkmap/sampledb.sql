drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

create table MONKEYS (
   ID bigint not null,
   NAME varchar(15),
   HOME_ADDRESS_ID bigint unique,
   COM_ADDRESS_ID bigint unique,
   primary key (ID)
);

create table ADDRESSES(
  ID bigint not null,
  CITY varchar(128),
  STREET varchar(128),
  PROVINCE varchar(128),
  ZIPCODE varchar(6),
  primary key(ID)
);

alter table MONKEYS add index IDX_HOME_ADDRESS(HOME_ADDRESS_ID), 
add constraint FK_HOME_ADDRESS foreign key (HOME_ADDRESS_ID) references ADDRESSES(ID);

alter table MONKEYS add index IDX_COM_ADDRESS(COM_ADDRESS_ID), 
add constraint FK_COM_ADDRESS foreign key (COM_ADDRESS_ID) references ADDRESSES(ID);
