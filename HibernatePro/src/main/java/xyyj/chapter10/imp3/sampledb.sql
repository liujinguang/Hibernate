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

create table JMONKEYS (
   MONKEY_ID bigint not null,
   COLOR varchar(15),
   primary key (MONKEY_ID)
);

create table CMONKEYS (
   MONKEY_ID bigint not null,
   LENGTH double precision,
   primary key (MONKEY_ID)
);

alter table MONKEYS add index IDX_TEAM(TEAM_ID), add constraint FK_TEAM foreign key (TEAM_ID) references TEAMS (ID);

alter table JMONKEYS add index IDX_MONKEY1(MONKEY_ID), add constraint FK_MONKEY1 foreign key (MONKEY_ID) references MONKEYS (ID);

alter table CMONKEYS add index IDX_MONKEY2(MONKEY_ID), add constraint FK_MONKEY2 foreign key (MONKEY_ID) references MONKEYS (ID);

insert into TEAMS(ID,NAME) values(1,'NBA');

insert into MONKEYS(ID,NAME,TEAM_ID) values(1,'Tom',1);
insert into JMONKEYS(MONKEY_ID,COLOR) values(1,'yellow');

insert into MONKEYS(ID,NAME,TEAM_ID) values(2,'Mike',1);
insert into JMONKEYS(MONKEY_ID,COLOR) values(2,'orange');

insert into MONKEYS(ID,NAME,TEAM_ID) values(3,'Jack',1);
insert into CMONKEYS(MONKEY_ID,LENGTH) values(3,1.2);

insert into MONKEYS(ID,NAME,TEAM_ID) values(4,'Linda',1);
insert into CMONKEYS(MONKEY_ID,LENGTH) values(4,2.0);
