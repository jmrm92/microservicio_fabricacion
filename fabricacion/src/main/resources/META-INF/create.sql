CREATE TABLE fabricadb.fabricaciones (
	id_fabricacion INT auto_increment NOT NULL,
	id_fabrica INT NOT NULL,
	id_modelo INT NOT NULL,
	fecha_fabricacion DATE NULL,
	coste_monetario DOUBLE NOT NULL,
	coste_piezas INT NOT NULL,
	cantidad_modelos INT NOT NULL,
	CONSTRAINT fabricaciones_pk PRIMARY KEY (id_fabricacion),
	CONSTRAINT fabricaciones_FK FOREIGN KEY (id_fabrica) REFERENCES fabricadb.fabricas(id_fabrica),
	CONSTRAINT fabricaciones_FK_1 FOREIGN KEY (id_modelo) REFERENCES fabricadb.modelos(id_modelo)
)