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



INSERT INTO grape VALUES ('aaa', '123', 'aa','aaa@naver.com');
INSERT INTO grape VALUES ('bbb', '123', 'nickname','bbb@naver.com');
INSERT INTO grape VALUES ('ccc', '123', 'nickname','ccc@naver.com');
select * from grape where id='bbb' and pw='123'

INSERT INTO publicbooks VALUES ('용감한포도잼', 1,'0','0','0');
INSERT INTO publicbooks VALUES ('용감한포도잼', 2,'0','0','0');
select * from publicbooks where title='용감한포도잼';
elect * from publicbooks

drop table grape cascade constraint;
drop table privacybooks;
drop table publicbooks;



create table grape (
id VARCHAR2(10) primary key,
pw VARCHAR2(10),
nickname varchar2(30),
email varchar2(30)
);

create table publicbooks (
title varchar2(100),
titlenum number(5),
num number(2),
txt varchar2(1000),
date1 date,
CONSTRAINT publicbooks_pk primary key (title, Num)
);

create table privacybooks (
id VARCHAR2(10) ,
title varchar2(100),
titlenum number(5),
num number(2),
txt varchar2(1000),
date2 date,
constraint privacy_id_fk foreign key(id) references grape(id),
CONSTRAINT privacybooks_pk primary key (id, title, Num)
);



select * from grape

select * from privacybooks
select * from publicbooks


INSERT INTO privacybooks VALUES ('bbb', '하이하이2',0,0,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이2',0,1,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이2',0,2,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이3',1,0,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이3',1,1,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이3',1,2,'7',sysdate);

INSERT INTO privacybooks VALUES ('bbb', '하이하이3',1,3,'7',sysdate);



INSERT INTO publicbooks VALUES ('용감한',0, 0,'123',sysdate);

INSERT INTO publicbooks VALUES ('용감한',0, 1,'123',sysdate);

INSERT INTO publicbooks VALUES ('용감한',0, 2,'123',sysdate);

INSERT INTO publicbooks VALUES ('포도잼',1, 0,'123',sysdate);

INSERT INTO publicbooks VALUES ('포도잼',1, 1,'123',sysdate);

INSERT INTO publicbooks VALUES ('포도잼',1, 2,'123',sysdate);

INSERT INTO publicbooks VALUES ('사과잼이 사과잼을 사과잼으로 사과잼하여 사과잼했어요',2, 0,'123',sysdate);



select * from privacybooks
select title from privacybooks where id='ccc' group by title

create table privacybooks (
id VARCHAR2(40) ,
title varchar2(100),
num number(35),
titleNum number(35),
txt varchar2(1000),
date2 date,
constraint study_id_fk foreign key(id) references grape(id),
CONSTRAINT privacybooks_pk primary key (id, title, titleNum)
);

INSERT INTO privacybooks VALUES ('ttt', '하이하이2','7','7','7');

select title from privacybooks where id='ccc' group by title;

select title from privacybooks

select * from privacybooks where id=? title =? 
