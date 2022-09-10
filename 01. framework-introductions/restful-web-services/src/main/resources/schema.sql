CREATE TABLE `COURSE` (
    `id`         bigint  PRIMARY KEY,
    `name` VARCHAR(250) NOT NULL,
    `author` VARCHAR(50) NOT NULL
);

insert into COURSE  ( ID,NAME,AUTHOR ) values(1,'nestor01','nestor1');
insert into COURSE  ( ID,NAME,AUTHOR ) values(2,'nestor02','nestor2');
insert into COURSE  ( ID,NAME,AUTHOR ) values(3,'nestor03','nestor3');


select *from COURSE;