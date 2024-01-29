DROP DATABASE IF EXISTS  CENSO_EUROPA;
CREATE DATABASE IF NOT EXISTS CENSO_EUROPA;
USE CENSO_EUROPA;

/*Se crea la tabla PORCENTAJES_RANGOEDAD para almacenar la informacion del numero de habitantes que existe en cada pais*/

CREATE TABLE PORCENTAJES_RANGOEDAD (
	NOMBRE_PAIS VARCHAR(30) NOT NULL COMMENT 'Nombre del pais',
	RANGO_1_9 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad esta comprendida entre 1 y 9 anios',
	RANGO_10_17 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad esta comprendida entre 10 y 17 anios',
    RANGO_18_25 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad esta comprendida entre 18 y 25 anios',
    RANGO_26_40 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad esta comprendida entre 26 y 40 anios',
    RANGO_41_65 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad esta comprendida entre 41 y 65 anios',
    RANGO_MAS_66 INT(3) NOT NULL COMMENT 'Porcentaje de habitantes cuya edad es superior o igual a 66 anios',
    TOTAL_HABITANTES INT(8) NOT NULL COMMENT 'Numero total de habitantes que tiene el pais',
    CONSTRAINT PK_PORCENTAJES_RANGOEDAD PRIMARY KEY (NOMBRE_PAIS)
);

/*Se insertan los datos para Espania*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Espania', 10, 8, 14, 28, 25, 15, 47420000);

/*Se insertan los datos para Alemania*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Alemania', 16, 19, 15, 20, 14, 16, 83210000);

/*Se insertan los datos para Francia*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Francia', 14, 10, 9, 25, 17, 25, 67750000);

/*Se insertan los datos para Italia*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Italia', 13, 12, 20, 21, 23, 11, 59110000);

/*Se insertan los datos para Portugal*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Portugal', 4, 5, 20, 26, 15, 30, 10330000);

/*Se insertan los datos para Reino Unido*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Reino Unido', 8, 17, 22, 22, 15, 16, 67150000);

/*Se insertan los datos para Polonia*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Polonia', 10, 15, 18, 26, 17, 14, 37650000);

/*Se insertan los datos para Paises Bajos*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Paises Bajos', 5, 16, 24, 17, 19, 19, 17590000);

/*Se insertan los datos Rumania*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Rumania', 15, 10, 27, 16, 18, 14, 19120000);

/*Se insertan los datos para Grecia*/
INSERT INTO PORCENTAJES_RANGOEDAD (NOMBRE_PAIS, RANGO_1_9, RANGO_10_17, RANGO_18_25, RANGO_26_40, RANGO_41_65, RANGO_MAS_66, TOTAL_HABITANTES)
VALUES ('Grecia', 7, 5, 17, 29, 25, 17, 10640000);


/*Se crea la tabla de CANTANTES para guardar la informacion de cada uno de los aspirantes a ganar Eurovision*/

CREATE TABLE CANTANTES (
	PAIS VARCHAR(20) NOT NULL COMMENT 'Nombre del pais del cantante',
    NOMBRE VARCHAR(20) NOT NULL COMMENT 'Nombre del cantante',
    NOMBRE_CANCION VARCHAR(100) COMMENT 'Nombre de la cancion que presenta',
    CONSTRAINT PK_CANTANTES PRIMARY KEY (PAIS)
);

INSERT INTO CANTANTES (PAIS, NOMBRE, NOMBRE_CANCION)
VALUES ('Espania', 'Joel', 'Un elefante se balanceaba'), 
('Alemania', 'Hilda', 'Que llueva, que llueva'), 
('Francia', 'Bastian', 'Estrellita donde estás'), 
('Italia', 'Gianmarco', 'El senior Don Gato'), 
('Portugal', 'Matilde', 'El corro de la patata'), 
('Reino Unido', 'Hanna', 'Cucu cantaba la rana'), 
('Polonia', 'Anca', 'Cumpleanios feliz'), 
('Paises Bajos', 'Dennis', 'Al pasar la barca'),
('Rumania', 'Amalia', 'Cinco lobitos'),
('Grecia', 'Orelle', 'Mi carro');



/*Se cre una tabla de RESULTADOS FINALES DE LA GALA EUROVISION para guardar los resultados de todos los paises*/
CREATE TABLE RESULTADOS_EUROVISION (
	ID_RESULTADOS_EUROVISION INT AUTO_INCREMENT NOT NULL COMMENT 'ID de resultados de EurovisiOn',
    FECHA_GALA DATE NULL COMMENT 'Fecha de la Gala de Eurovision',
    ESPANIA INT NULL COMMENT 'Puntacion final de Espania',
    ALEMANIA INT NULL COMMENT 'Puntacion final de Alemania',
    FRANCIA INT NULL COMMENT 'Puntacion final de Francia',
    ITALIA INT NULL COMMENT 'Puntacion final de Italia',
    PORTUGAL INT NULL  COMMENT 'Puntacion final de Portugal',
    REINO_UNIDO INT NULL  COMMENT 'Puntacion final de Reino Unido',
    POLONIA INT NULL COMMENT 'Puntacion final de Polonia',
    PAISES_BAJOS INT  NULL COMMENT 'Puntacion final de Paises Bajos',
    RUMANIA INT NULL COMMENT 'Puntacion final de Rumania',
    GRECIA INT NULL COMMENT 'Puntacion final de Grecia',
    PAIS_GANADOR VARCHAR(20) NULL COMMENT 'Nombre del pais ganador',
    CONSTRAINT PK_RESULTADOS_EUROVISION PRIMARY KEY (ID_RESULTADOS_EUROVISION)
);


/*Se crea una tabla de RESULTADOS DE LA FASE NACIONAL de cada cantante por pais, con los tres paises que han votado relacionados con la puntuacion*/
/*Utilizamos como PK el nombre del cantante, ya que en el enunciado del ejercicio especifica que el votante vota al cantante, no al pais*/

CREATE TABLE RESULTADOS_FASE_NACIONAL (
    PAIS VARCHAR(20) NOT NULL COMMENT 'Nombre del pais',
    CANTANTE_TERCERO VARCHAR(20) NULL COMMENT 'Nombre del cantante que votan como tercero con 8 puntos',
	CANTANTE_SEGUNDO VARCHAR(20) NULL COMMENT 'Nombre del cantante que votan como segundo con 10 puntos',
	CANTANTE_PRIMERO VARCHAR(20) NULL COMMENT 'Nombre del cantante que votan como primero con 15 puntos',
    CONSTRAINT PK_PAIS PRIMARY KEY (PAIS)
);


