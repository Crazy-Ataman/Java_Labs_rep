USE master
CREATE database Lab9
use Lab9
create table user_auth (
    login nvarchar(50),
    password nvarchar(50)
)

alter table user_auth add [status] nvarchar(20)