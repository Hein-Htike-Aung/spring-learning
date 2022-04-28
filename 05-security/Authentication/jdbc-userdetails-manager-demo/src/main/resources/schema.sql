

-- create schema security_test;

create table if not exists `security_test`.`users` (
    `id` int not null auto_increment,
    `username` varchar (45) null,
    `password` varchar (45) null,
    `enabled` int not null,
    primary key(`id`)
);

create table if not exists `security_test`.`authorities`(
    `id` int not null auto_increment,
    `username` varchar(45) null,
    `authority` varchar (45) null,
    primary key (`id`)
);