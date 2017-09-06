drop table if exists PhoneBook;

create table user_data (
--   id identity,
  userId varchar(50) not null,
  password varchar(50) not null,
  fname varchar(40) not null,
  lname varchar(40) not null
);

-- userId, password, firstName, lastName