


create table if not exists `spring`.`product` (
    `id` int not null auto_increment,
    `name` varchar (34) null,
    `owner` varchar (45) null,
    primary key (`id`)
);