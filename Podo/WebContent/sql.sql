CREATE TABLE "HR".bookmember 
   (   
   "ID" VARCHAR2(50 BYTE) , 
   "PW" VARCHAR2(50 BYTE)
    )

select * from bookmember
 

 
INSERT INTO bookmember VALUES ('ttt', '123');
INSERT INTO bookmember VALUES ('aaa', '123');

select * from bookmember where id='ttt' and pw='123'
 
commit



INSERT INTO grape VALUES ('ttt', '123', 'nickname');
select * from grape where id='ttt' and pw='123'

INSERT INTO publicbooks VALUES ('용감한포도잼', 1,'0','0','0');
INSERT INTO publicbooks VALUES ('용감한포도잼', 2,'0','0','0');
select * from publicbooks where title='용감한포도잼';
select * from publicbooks

drop table grape;
drop table privacybooks;
drop table voices;
drop table publicbooks;

create table publicbooks (
title varchar2(100),
titleNum number(30),
txt varchar2(1000),
CONSTRAINT publicbooks_pk primary key (title, titleNum)
);


select * from grape

create table grape(
id VARCHAR2(40) primary key,
pw VARCHAR2(10) ,
nickname varchar2(30)
);


select * from privacybooks

create table privacybooks (
id VARCHAR2(40) ,
title varchar2(100),
titleNum number(35),
txt varchar2(1000),
constraint study_id_fk foreign key(id) references grape(id),
CONSTRAINT privacybooks_pk primary key (id, title, titleNum)
);

create table voices  (
id VARCHAR2(40) primary key,
voice1 VARCHAR2(1000),
voice2 VARCHAR2(1000),
voice3 VARCHAR2(1000),
analyzedvoice1 VARCHAR2(1000),
analyzedvoice2 VARCHAR2(1000),
analyzedvoice3 VARCHAR2(1000),
constraint voices_id_fk foreign key(id)
references grape(id));