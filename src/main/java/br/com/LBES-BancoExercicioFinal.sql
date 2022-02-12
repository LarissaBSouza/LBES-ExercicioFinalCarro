create table veiculos (
	id int(3) not null auto_increment,
	modelo varchar(120) not null,
	ano int(4) not null,
	
	primary key(id)
	
);

create table IPVA (
	id int(3) not null auto_increment,
	ano int(4) not null,
	
	primary key(id)
);


show tables;

select * from veiculos;
select * from ipva;

drop table veiculos ;
drop table ipva ;