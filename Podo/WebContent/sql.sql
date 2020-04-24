 CREATE TABLE "HR".bookmember 
   (   
   "ID" VARCHAR2(50 BYTE) , 
   "PW" VARCHAR2(50 BYTE)
    )

 select * from bookmember
 

 
 INSERT INTO bookmember VALUES ('ttt', '123');

 select * from bookmember where id='ttt' and pw='123'
 
 commit