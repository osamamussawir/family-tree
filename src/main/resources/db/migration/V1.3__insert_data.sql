CREATE TABLE IF NOT EXISTS person (
  id INT PRIMARY KEY NOT NULL ,
  father_id INT,
  mother_id INT,
  name VARCHAR(100)
);

insert into person (id , father_id , mother_id , name) values (10001 , null , null , 'taimoor');
insert into person (id , father_id , mother_id , name) values (10002 , null , null , 'aisha');
insert into person (id , father_id , mother_id , name) values (10003 , null , null , 'sharjeel');
insert into person (id , father_id , mother_id , name) values (10004 , null , null , 'muskan');
insert into person (id , father_id , mother_id , name) values (10005 , 10001 , 10002 , 'ahmed');
insert into person (id , father_id , mother_id , name) values (10006 , 10001 , 10002 , 'fatma');
insert into person (id , father_id , mother_id , name) values (10007 , 10003 , 10004 , 'shouriya');