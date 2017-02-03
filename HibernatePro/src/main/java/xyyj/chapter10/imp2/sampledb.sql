use db_hibernate;

create table TEAMS (
   ID bigint not null,
   NAME varchar(15),
   primary key (ID)
);
create table MONKEYS (
   ID bigint not null,
   NAME varchar(15),
   MONKEY_TYPE varchar(2),
   COLOR varchar(15),
   LENGTH double precision,
   TEAM_ID bigint,
   primary key (ID)
);

alter table MONKEYS add index IDX_TEAM(TEAM_ID), add constraint FK_TEAM foreign key (TEAM_ID) references TEAMS (ID);

insert into TEAMS(ID,NAME) values(1,'ABC Company');

insert into MONKEYS(ID,MONKEY_TYPE,NAME,COLOR,LENGTH,TEAM_ID) values(1,'JM','Tom','yellow',null,1);

insert into MONKEYS(ID,MONKEY_TYPE,NAME,COLOR,LENGTH,TEAM_ID) values(2,'JM','Mike','orange',null,1);

insert into MONKEYS(ID,MONKEY_TYPE,NAME,COLOR,LENGTH,TEAM_ID) values(3,'CM','Jack',null,1.2,1);

insert into MONKEYS(ID,MONKEY_TYPE,NAME,COLOR,LENGTH,TEAM_ID) values(4,'CM','Linda',null,2.0,1);



