/*********************************/
DROP TABLE IF EXISTS USUARIOS;
  
CREATE TABLE USUARIOS (
  ID_USUARIO INT AUTO_INCREMENT  PRIMARY KEY,
  PRIMER_NOMBRE VARCHAR(250),
  SEGUNDO_NOMBRE VARCHAR(250),
  PRIMER_APELLIDO VARCHAR(250),
  SEGUNDO_APELLIDO VARCHAR(250),
  USERNAME VARCHAR(250),
  PASSWORD VARCHAR(250)
);

INSERT INTO USUARIOS (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO, SEGUNDO_APELLIDO,USERNAME,PASSWORD) VALUES
  ('RENE','ATILIO','MORAN','TOBAR','RENE','P@SSWORD123$');
/*********************************/
/*********************************/
DROP TABLE IF EXISTS TIPO_CONTACTO;
  
CREATE TABLE TIPO_CONTACTO (
  ID_TIPO_CONTACTO INT AUTO_INCREMENT  PRIMARY KEY,
  TIPO_CONTACTO VARCHAR(250)
);

INSERT INTO TIPO_CONTACTO (ID_TIPO_CONTACTO,TIPO_CONTACTO) VALUES
  (1,'FAMILIA'),
  (2,'TRABAJO'),
  (3,'AMIGOS');

/*********************************/
/*********************************/
DROP TABLE IF EXISTS TIPO_TELEFONO;
  
CREATE TABLE TIPO_TELEFONO (
  ID_TIPO_TELEFONO INT AUTO_INCREMENT  PRIMARY KEY,
  TIPO_TELEFONO VARCHAR(250)
);

INSERT INTO TIPO_TELEFONO (ID_TIPO_TELEFONO,TIPO_TELEFONO) VALUES
  (1,'CELULAR'),
  (2,'FIJO');

/*********************************/
DROP TABLE IF EXISTS CONTACTOS;
  
CREATE TABLE CONTACTOS (
  ID_CONTACTO INT AUTO_INCREMENT  PRIMARY KEY,
  ID_USUARIO INT,
  PRIMER_NOMBRE VARCHAR(250),
  SEGUNDO_NOMBRE VARCHAR(250),
  PRIMER_APELLIDO VARCHAR(250),
  SEGUNDO_APELLIDO VARCHAR(250),
  ID_TIPO_CONTACTO INT,
  CONSTRAINT FK_ID_USUARIO FOREIGN KEY (ID_USUARIO)
  REFERENCES USUARIOS (ID_USUARIO)
  ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT FK_ID_TIPO_CONTACTO FOREIGN KEY (ID_TIPO_CONTACTO)
  REFERENCES TIPO_CONTACTO (ID_TIPO_CONTACTO)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

INSERT INTO CONTACTOS (ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO, SEGUNDO_APELLIDO,ID_TIPO_CONTACTO) VALUES
  (1,'JOSE','ANTONIO','LOPEZ','PEREZ',3),
  (1,'MARIO','JOSE','MARTINEZ','LOPEZ',1);
  
/*********************************/
DROP TABLE IF EXISTS CONTACTOS_TELEFONOS;
  
CREATE TABLE CONTACTOS_TELEFONOS (
  ID_TELEFONO_CONTACTO INT AUTO_INCREMENT  PRIMARY KEY,
  ID_CONTACTO INT,
  ID_TIPO_TELEFONO INT,
  TELEFONO VARCHAR(250),
  CONSTRAINT FK_ID_CONTACTO FOREIGN KEY (ID_CONTACTO)
  REFERENCES CONTACTOS (ID_CONTACTO)
  ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT FK_ID_TIPO_TELEFONO FOREIGN KEY (ID_TIPO_TELEFONO)
  REFERENCES TIPO_TELEFONO (ID_TIPO_TELEFONO)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

INSERT INTO CONTACTOS_TELEFONOS (ID_CONTACTO,ID_TIPO_TELEFONO,TELEFONO) VALUES
  (1,1,'7777777'),
  (1,1,'7777775'),
  (1,2,'2222222');

/*********************************/
DROP TABLE IF EXISTS TIPO_CORREO;
  
CREATE TABLE TIPO_CORREO (
  ID_TIPO_CORREO INT AUTO_INCREMENT  PRIMARY KEY,
  TIPO_CORREO VARCHAR(250)
);

INSERT INTO TIPO_CORREO (ID_TIPO_CORREO,TIPO_CORREO) VALUES
  (1,'PERSONAL'),
  (2,'TRABAJO');
  
/**********************************/
  
CREATE TABLE CONTACTOS_CORREOS (
  ID_CORREO_CONTACTO INT AUTO_INCREMENT  PRIMARY KEY,
  ID_CONTACTO INT,
  ID_TIPO_CORREO INT,
  CORREO VARCHAR(250),
  CONSTRAINT FK_ID_CONTACTO2 FOREIGN KEY (ID_CONTACTO)
  REFERENCES CONTACTOS (ID_CONTACTO)
  ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT FK_ID_TIPO_CORREO FOREIGN KEY (ID_TIPO_CORREO)
  REFERENCES TIPO_CORREO (ID_TIPO_CORREO)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

INSERT INTO CONTACTOS_CORREOS (ID_CONTACTO,ID_TIPO_CORREO,CORREO) VALUES
  (1,1,'DEMO@MAIL.COM'),
  (1,2,'CORREO2@MAIL.COM');
  
/*********************************/
DROP TABLE IF EXISTS TIPO_DIRECCION;
  
CREATE TABLE TIPO_DIRECCION (
  ID_TIPO_DIRECCION INT AUTO_INCREMENT  PRIMARY KEY,
  TIPO_DIRECCION VARCHAR(250)
);

INSERT INTO TIPO_DIRECCION (ID_TIPO_DIRECCION,TIPO_DIRECCION) VALUES
  (1,'DOMICILIO'),
  (2,'TRABAJO');
  
  /****************************************/
CREATE TABLE CONTACTOS_DIRECCIONES (
  ID_DIRECCION_CONTACTO INT AUTO_INCREMENT  PRIMARY KEY,
  ID_CONTACTO INT,
  ID_TIPO_DIRECCION INT,
  DIRECCION VARCHAR(250),
  CONSTRAINT FK_ID_CONTACTO3 FOREIGN KEY (ID_CONTACTO)
  REFERENCES CONTACTOS (ID_CONTACTO)
  ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT FK_ID_TIPO_DIRECCION FOREIGN KEY (ID_TIPO_DIRECCION)
  REFERENCES TIPO_DIRECCION (ID_TIPO_DIRECCION)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

INSERT INTO CONTACTOS_DIRECCIONES (ID_CONTACTO,ID_TIPO_DIRECCION,DIRECCION) VALUES
  (1,1,'DIRECCION UNO'),
  (1,2,'DIRECCION DOS');

/*********************************/
DROP TABLE IF EXISTS CITAS;
  
CREATE TABLE CITAS (
  ID_CITA INT AUTO_INCREMENT  PRIMARY KEY,
  ID_USUARIO INT,
  DECRIPCION VARCHAR(250),
  FECHA DATE,
  CONSTRAINT FK_ID_USUARIO2 FOREIGN KEY (ID_USUARIO)
  REFERENCES USUARIOS (ID_USUARIO)
);