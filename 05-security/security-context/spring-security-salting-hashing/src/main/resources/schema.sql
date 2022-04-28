


create table Users(
    username varchar(50) not null primary key,
    password varchar (500) not null,
    enabled boolean not null
);

create table Authorities(
    username varchar (50) not null,
    authority varchar (50) not null,
    constraint fk_athorites_users foreign key (username) references users(username)
);