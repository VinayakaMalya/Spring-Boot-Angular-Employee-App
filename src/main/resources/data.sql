create table address (
       id bigint not null auto_increment,
        city varchar(255),
        country varchar(255),
        postal varchar(255),
        region varchar(255),
        street varchar(255),
        primary key (id))