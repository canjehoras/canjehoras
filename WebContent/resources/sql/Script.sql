-- CREAR DATABASE --
DROP DATABASE IF EXISTS canjehoras;
CREATE DATABASE canjehoras /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
use canjehoras;

-- TABLA PROVINCIA --
CREATE TABLE PROVINCIA (
	ID INT(11) NOT NULL AUTO_INCREMENT,
	DESCRIPCION VARCHAR(50) NOT NULL, 
	PRIMARY KEY (ID),
	UNIQUE (DESCRIPCION),
	INDEX (DESCRIPCION)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- DATOS POR DEFECTO -- TABLA PROVINCIA --
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('A CORUÑA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ALAVA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ALBACETE');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ALICANTE');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ALMERIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ASTURIAS');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('AVILA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('BADAJOZ');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('BARCELONA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('BURGOS');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CACERES');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CADIZ');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CANTABRIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CASTELLON');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CEUTA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CIUDAD REAL');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CORDOBA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('CUENCA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('GIRONA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('GRANADA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('GUADALAJARA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('GUIPUZCOA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('HUELVA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('HUESCA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ILLES BALEARS');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('JAEN');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('LA RIOJA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('LAS PALMAS');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('LEON');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('LLEIDA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('LUGO');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('MADRID');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('MALAGA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('MELILLA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('MURCIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('NAVARRA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('OURENSE');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('PALENCIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('PONTEVEDRA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('SALAMANCA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('SANTA CRUZ DE TENERIFE');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('SEGOVIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('SEVILLA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('SORIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('TARRAGONA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('TERUEL');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('TOLEDO');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('VALENCIA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('VALLADOLID');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('VIZCAYA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ZAMORA');
INSERT INTO PROVINCIA(DESCRIPCION) VALUES ('ZARAGOZA');

-- TABLA CATEGORIA --
CREATE TABLE CATEGORIA (
	ID INT(11) NOT NULL AUTO_INCREMENT,
	DESCRIPCION VARCHAR(50) NOT NULL, 
	PRIMARY KEY (ID),
	UNIQUE (DESCRIPCION),
	INDEX (DESCRIPCION)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- DATOS POR DEFECTO -- TABLA CATEGORIA --
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('OCIO');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('BRICOLAJE');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('ALIMENTACIÓN');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('MOTOR');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('JUGUETES');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('NIÑOS');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('INFORMÁTICA');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('COLECCIONES');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('DEPORTE');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('ARTE');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('LIBROS');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('BELLEZA');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('MODA');
INSERT INTO CATEGORIA(DESCRIPCION) VALUES ('OTROS');

-- TABLA AGENDA --
CREATE TABLE AGENDA(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	ESTADO TINYINT(1) UNSIGNED DEFAULT '1' NULL COMMENT '1-DISPONIBLE / 0-NO DISPONIBLE',
	PRIMARY KEY (ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- TABLA USUARIO --
CREATE TABLE USUARIO (
	ID INT(11) NOT NULL AUTO_INCREMENT,
	IDIOMA VARCHAR(2) NOT NULL,
	PERFIL VARCHAR(2) NOT NULL,
	FECHA_ALTA DATE NOT NULL,
	FECHA_BAJA DATE NULL DEFAULT NULL,
	CORREO_ELECTRONICO VARCHAR(50) NOT NULL,
	PASS VARCHAR(20) NOT NULL,	
	NOMBRE VARCHAR(20) NOT NULL,
	APELLIDO1 VARCHAR(25) NOT NULL,
	APELLIDO2 VARCHAR(25),
	ID_PROVINCIA INT,
	MOVIL VARCHAR(15) NOT NULL,
	TELEFONO VARCHAR(15),
	WASSAP TINYINT(1) UNSIGNED DEFAULT '0' NULL COMMENT '1-SI / 0-NO',
	NUM_ACCESO INT,
	FECHA_ULTIMO_ACCESO DATE NULL DEFAULT NULL,
	ID_AGENDA INT,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_PROVINCIA) REFERENCES PROVINCIA(ID),
	FOREIGN KEY (ID_AGENDA) REFERENCES AGENDA(ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- DATOS POR DEFECTO -- TABLA USUARIO --
INSERT INTO USUARIO (IDIOMA, PERFIL, FECHA_ALTA, CORREO_ELECTRONICO, PASS, NOMBRE, APELLIDO1, ID_PROVINCIA, MOVIL) VALUES ('ES', 'A', '2015/01/25', 'canjehoras@gmail.com', 'root', 'Administrador', 'Usuario', 52, '652434891');

-- TABLA PREF_PROVINCIA --
CREATE TABLE PREF_PROVINCIA(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	ID_USUARIO INT NOT NULL,
	ID_PROVINCIA INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
	FOREIGN KEY (ID_PROVINCIA) REFERENCES PROVINCIA(ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- TABLA PREF_CATEGORIA --
CREATE TABLE PREF_CATEGORIA(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	ID_USUARIO INT NOT NULL,
	ID_CATEGORIA INT NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
	FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- TABLA TRUEQUE --
CREATE TABLE TRUEQUE(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	ID_USUARIO INT NOT NULL,
	ID_PROVINCIA INT NOT NULL,
	FECHA_ALTA DATE NOT NULL,
	ID_CATEGORIA INT NOT NULL,
	ESTADO VARCHAR(1) NOT NULL,
	TITULO VARCHAR(50) NOT NULL,
	DESCRIPCION VARCHAR(500) NOT NULL,
	TIPO VARCHAR(1),
	IMAGEN LONGBLOB,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
	FOREIGN KEY (ID_PROVINCIA) REFERENCES PROVINCIA(ID),
	FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;

-- TABLA CANJE --
CREATE TABLE CANJE(
	ID_USUARIO INT NOT NULL,
	ID_TRUEQUE INT NOT NULL,
	ID_AGENDA INT NOT NULL,
	FECHA DATE NOT NULL,
	HORA_INICIO VARCHAR(5) NOT NULL,
	HORA_FIN VARCHAR(5) NOT NULL,
	PRIMARY KEY (ID_USUARIO, ID_AGENDA, ID_TRUEQUE),
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
	FOREIGN KEY (ID_TRUEQUE) REFERENCES TRUEQUE(ID),
	FOREIGN KEY (ID_AGENDA) REFERENCES AGENDA(ID)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET utf8 COLLATE utf8_bin */;