create table ninja(
	id int primary key not null auto_increment,
    nombre varchar(45) not null,
    rango ENUM("A", "B", "C", "S") not null,
    aldea varchar(45)
);

create table habilidad(
	idNinja int not null,
    nombre varchar(45) not null,
    descripcion varchar(100) not null,
    foreign key (idNinja) references ninja(id)
);

create table mision(
	id int primary key not null auto_increment,
    descripcion varchar(100) not null,
    rango ENUM("A", "B", "C", "S") not null,
    recompensa Double not null
);

create table misionNinja(
	id int primary key not null auto_increment,
	idNinja int not null,
    idMision int not null,
    fechaInicio date not null,
    fechaFin date,
    foreign key (idNinja) references ninja(id),
    foreign key (idMision) references mision(id)
);