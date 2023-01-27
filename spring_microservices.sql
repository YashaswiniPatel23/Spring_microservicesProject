create database project_db;
use project_db;

create table bank(
bank_id int primary key,
bank_name varchar(30),bank_city varchar(40));

select *from bank;
insert into bank values(1,'SBI','Hyderabad');
insert into bank values(2,'ICICI','Bangalore');
insert into bank values(3,'AXIS','Hyderabad');
insert into bank values(4,'CANARA','Bangalore');

select *from bank;

create table customer(
cid int primary key,
customer_name varchar(30),
city varchar(40),
bank_id int);

insert into customer values(111,'Yashaswini','Hyderabad',1);
insert into customer values(112,'Fiza','Bangalore',2);
insert into customer values(113,'Suraj','Hyderabad',3);
insert into customer values(114,'Harshad','Bangalore',4);
insert into customer values(115,'Ananya','Hyderabad',1);
insert into customer values(116,'Likhitha','Bangalore',2);
insert into customer values(117,'Keerthi','Hyderabad',3);
insert into customer values(118,'Aakash','Bangalore',4);

select *from customer;
