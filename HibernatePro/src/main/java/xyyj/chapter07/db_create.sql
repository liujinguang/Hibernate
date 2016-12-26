drop database if exists db_hibernate;
create database db_hibernate;
use db_hibernate;

create table TEAMS (
   ID bigint not null,
   NAME varchar(15),
   primary key (ID)
);
create table MONKEYS (
   ID bigint not null,
   NAME varchar(15),
   TEAM_ID bigint,
   primary key (ID)
);
alter table MONKEYS add index IDX_TEAM(TEAM_ID), add constraint FK_TEAM foreign key (TEAM_ID) references TEAMS (ID);

insert into TEAMS(ID,NAME) values(1,'BULL');
insert into TEAMS(ID,NAME) values(2,'DREAM');
insert into TEAMS(ID,NAME) values(3,'STAR');
insert into TEAMS(ID,NAME) values(4,'SUN');


insert into MONKEYS(ID,NAME,TEAM_ID) values(1,'Tom',1);
insert into MONKEYS(ID,NAME,TEAM_ID) values(2,'Mike',1);
insert into MONKEYS(ID,NAME,TEAM_ID) values(3,'Jack',2);
insert into MONKEYS(ID,NAME,TEAM_ID) values(4,'Bill',3);
insert into MONKEYS(ID,NAME,TEAM_ID) values(5,'Bern',4);
insert into MONKEYS(ID,NAME,TEAM_ID) values(6,'Linda',null);
