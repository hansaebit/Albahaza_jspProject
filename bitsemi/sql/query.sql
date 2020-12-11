-- show databases;
--
-- use bitsemi;
-- show tables;
-- show status;
--
-- desc member;
--
-- create database bitsemi_test;
-- use bitsemi_test;
--
-- select user();
-- select database();
--
-- -- auto-generated definition
-- create table member
-- (
--     num       int auto_increment
--         primary key,
--     id        varchar(20)  null,
--     name      varchar(50)  null,
--     age       tinyint      null,
--     gender    varchar(10)  null,
--     phonenum  varchar(50)  null,
--     email     varchar(100) null,
--     ishire    varchar(10)  null,
--     likes     int          null,
--     createday datetime     null,
--     pass      varchar(20)  null,
--     constraint email
--         unique (email),
--     constraint id
--         unique (id),
--     constraint phonenum
--         unique (phonenum)
-- );
--
-- insert into member (id,
--                     pass,
--                     name,
--                     age,
--                     gender,
--                     phonenum,
--                     email,
--                     ishire,
--                     likes,
--                     createday)
-- values (?, ?, ?, ?, ?, ?, ?, ?, ?, now());
--
-- insert into bitsemi_test.member (id, pass, name, age, gender, phonenum, email, ishire, likes, createday)
-- values ('yang',
--         '1234',
--         'yang',
--         10,
--         'male',
--         '010-1234-1234',
--         'asdf@gmail.com',
--         'true',
--         0,
--         now());


-- -- auto-generated definition
-- create table joboffer
-- (
--     num       int auto_increment
--         primary key,
--     id        varchar(20)   null,
--     location  varchar(100)  null,
--     jobtype   varchar(100)  null,
--     abletime  varchar(500)  null,
--     introduce varchar(2000) null,
--     pay       int           null,
--     writeday  datetime      null,
--     constraint joboffer_ibfk_1
--         foreign key (id) references member (id)
-- );
--
-- create index id
--     on joboffer (id);
--
--
-- -- auto-generated definition
-- create table jobsearch
-- (
--     num       int auto_increment
--         primary key,
--     id        varchar(20)   null,
--     location  varchar(100)  null,
--     jobtype   varchar(100)  null,
--     abletime  varchar(500)  null,
--     introduce varchar(2000) null,
--     career    varchar(1000) null,
--     writeday  datetime      null,
--     constraint jobsearch_ibfk_1
--         foreign key (id) references member (id)
-- );
--
-- create index id
--     on jobsearch (id);
--
--
-- -- auto-generated definition
-- create table zipcode
-- (
--     num int auto_increment
--         primary key,
--     gu  varchar(10) null
-- );
--
--
--
--
--

-- select * from bitsemi_test.member;
-- delete from bitsemi_test.member;
-- desc member;
-- #
-- # select * from member;
-- # select * from bitsemi.member;
-- # delete from bitsemi.member;
-- # alter table bitsemi_test.member modify likes int;
-- # alter table table_name auto_increment=1;
--
-- # select name,likes from member;

-- alter table zipcode auto_increment = 1;
-- delete from zipcode;
-- select * from zipcode order by gu;
-- desc zipcode;
-- insert into zipcode (gu) values ('강서구');
-- insert into zipcode (gu) values ('구로구');
-- insert into zipcode (gu) values ('양천구');
-- insert into zipcode (gu) values ('금천구');
-- insert into zipcode (gu) values ('관악구');
-- insert into zipcode (gu) values ('서초구');
-- insert into zipcode (gu) values ('강남구');
-- insert into zipcode (gu) values ('송파구');
-- insert into zipcode (gu) values ('강동구');
-- insert into zipcode (gu) values ('광진구');
-- insert into zipcode (gu) values ('성동구');
-- insert into zipcode (gu) values ('용산구');
-- insert into zipcode (gu) values ('마포구');
-- insert into zipcode (gu) values ('서대문구');
-- insert into zipcode (gu) values ('은평구');
-- insert into zipcode (gu) values ('종로구');
-- insert into zipcode (gu) values ('성북구');
-- insert into zipcode (gu) values ('동대문');
-- insert into zipcode (gu) values ('중랑구');
-- insert into zipcode (gu) values ('노원구');
-- insert into zipcode (gu) values ('강북구');
-- insert into zipcode (gu) values ('도봉구');
-- insert into zipcode (gu) values ('영등포구');

# insert into bitsemi.zipcode (gu) values ('강서구');
# insert into bitsemi.zipcode (gu) values ('구로구');
# insert into bitsemi.zipcode (gu) values ('양천구');
# insert into bitsemi.zipcode (gu) values ('금천구');
# insert into bitsemi.zipcode (gu) values ('관악구');
# insert into bitsemi.zipcode (gu) values ('서초구');
# insert into bitsemi.zipcode (gu) values ('강남구');
# insert into bitsemi.zipcode (gu) values ('송파구');
# insert into bitsemi.zipcode (gu) values ('강동구');
# insert into bitsemi.zipcode (gu) values ('광진구');
# insert into bitsemi.zipcode (gu) values ('성동구');
# insert into bitsemi.zipcode (gu) values ('용산구');
# insert into bitsemi.zipcode (gu) values ('마포구');
# insert into bitsemi.zipcode (gu) values ('서대문구');
# insert into bitsemi.zipcode (gu) values ('은평구');
# insert into bitsemi.zipcode (gu) values ('종로구');
# insert into bitsemi.zipcode (gu) values ('성북구');
# insert into bitsemi.zipcode (gu) values ('동대문');
# insert into bitsemi.zipcode (gu) values ('중랑구');
# insert into bitsemi.zipcode (gu) values ('노원구');
# insert into bitsemi.zipcode (gu) values ('강북구');
# insert into bitsemi.zipcode (gu) values ('도봉구');
# insert into bitsemi.zipcode (gu) values ('영등포구');


# drop table bitsemi_test.jobsearch;

use bitsemi_test;
# create table resume
# (
#     num       int auto_increment
#         primary key,
#     id        varchar(20)   null,
#     location  varchar(100)  null,
#     jobtype   varchar(100)  null,
#     abletime  varchar(500)  null,
#     introduce varchar(2000) null,
#     career    varchar(1000) null,
#     writeday  datetime      null
# );

# drop table bitsemi_test.joboffer;
# create table joboffer
# (
#     num        int auto_increment
#         primary key,
#     id         varchar(20)   null,
#     location   varchar(100)  null,
#     jobtype    varchar(100)  null,
#     abletime   varchar(500)  null,
#     introduce  varchar(2000) null,
#     pay        int           null,
#     writeday   datetime      null,
#     needpeople int           null,
#     applicant  varchar(2000) null
# );

show databases ;
show tables;

desc resume;
desc joboffer;

select * from member;
select * from resume;
select * from joboffer;
select * from zipcode;

# insert into joboffer (id, location, jobtype, abletime, introduce, pay, writeday, needpeople, applicant, xpoint, ypoint, companyname, phonenum)
select * from member where 'id'='yang5';

# alter table member drop constraint email;
# alter table member drop constraint phonenum;
# alter table favorites drop primary key , change num num int not null ;

delete from favorites;
drop table favorites;

create table favorites
(
    num         int auto_increment primary key,
    employeeid  varchar(50) not null,
    employerid  varchar(50) not null,
    employeenum int         not null,
    employernum int         not null,
    matchday    datetime,
    createday   datetime    not null
);

alter table favorites add matchday datetime not null
    , add createday datetime not null ;
alter table favorites change matchday matchday datetime;
alter table favorites add num int auto_increment primary key ;

-- insert into bitsemi_test.favorites (employeeid, employerid, employeenum, employernum, matchday, createday)
# alter table joboffer add term varchar(20);