drop table if exists PhoneBook;

create table PhoneBook (
--   id identity,
  num varchar(25) not null,
  fname varchar(25) not null,
  lname varchar(25) not null,
);