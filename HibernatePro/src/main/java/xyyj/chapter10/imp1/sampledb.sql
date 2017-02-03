use db_hibernate;

create table TEAMS (
   ID bigint not null,
   NAME varchar(15),
   primary key (ID)
);
create table JMONKEYS (
   ID bigint not null,
   NAME varchar(15),
   COLOR varchar(15),
   TEAM_ID bigint,
   primary key (ID)
);
create table CMONKEYS (
   ID bigint not null,
   NAME varchar(15),
   LENGTH double precision,
   TEAM_ID bigint,
   primary key (ID)
);
alter table JMONKEYS add index IDX1_TEAM(TEAM_ID), add constraint FK1_TEAM foreign key (TEAM_ID) references TEAMS (ID);
alter table CMONKEYS add index IDX2_TEAM(TEAM_ID), add constraint FK2_TEAM foreign key (TEAM_ID) references TEAMS (ID);

insert into TEAMS(ID,NAME) values(1,'NBA');

insert into JMONKEYS(ID,NAME,COLOR,TEAM_ID) values(1,'Tom','yellow',1);

insert into JMONKEYS(ID,NAME,COLOR,TEAM_ID) values(2,'Mike','orange',1);

insert into CMONKEYS(ID,NAME,LENGTH,TEAM_ID)
values(1,'Jack',1.2,1);

insert into CMONKEYS(ID,NAME,LENGTH,TEAM_ID)
values(2,'Linda',2.0,1);
