CREATE TABLE fabricadb.fabricacion (
	id_fabricacion INT auto_increment NOT NULL,
	id_fabrica INT NOT NULL,
	id_modelo INT NOT NULL,
	fecha_fabricacion DATE NOT NULL,
	coste_fabricacion varchar(100) NOT NULL,
	CONSTRAINT fabricacion_pk PRIMARY KEY (id_fabricacion),
	CONSTRAINT fabricacion_FK FOREIGN KEY (id_fabrica) REFERENCES fabricadb.fabrica(id_fabrica),
	CONSTRAINT fabricacion_FK_1 FOREIGN KEY (id_modelo) REFERENCES fabricadb.modelo(id_modelo)
)