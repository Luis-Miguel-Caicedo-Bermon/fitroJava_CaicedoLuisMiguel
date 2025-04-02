insert into ninja (nombre,rango,aldea) values
("naruto","S","konoha"),
("sasuke","S","konoha"),
("kakashi","A","konoha");

insert into habilidad(idNinja,nombre,descripcion) values
(1,"clones de sombra","crea multiples clones de sombra"),
(2,"Sharingan","ayuda a predecir movimientos"),
(3,"copy paste","puede copiar habilidades");

insert into mision(descripcion,rango,recompensa) values
("detener a los akatsuki","S",5000),
("unirse a los akatsuki","S",5000),
("salvar a rin","A",4000);

insert into misionNinja(idNinja,idMision,fechaInicio,fechaFin) values
(1,1,current_date(),null),
(2,2,current_date(),null),
(3,3,current_date(),null);

insert into mision(descripcion,rango,recompensa) values
("detener a orochimaru","S",5000);