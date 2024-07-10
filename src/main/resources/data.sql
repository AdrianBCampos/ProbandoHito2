CREATE TABLE IF NOT EXISTS canciones (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         nombre VARCHAR(255) NOT NULL,
    letra TEXT,
    genero VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS artistas (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(255) NOT NULL,
                                        genero VARCHAR(50),
                                        pais_origen VARCHAR(100),
                                        instrumento VARCHAR(100),
                                        fecha_nacimiento DATE,
                                        fecha_fallecimiento DATE,
                                        biografia TEXT
    );

CREATE TABLE IF NOT EXISTS discos (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      nombre VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    fecha_lanzamiento DATE
    );

CREATE TABLE IF NOT EXISTS artistas_canciones (
                                                  artista_id BIGINT,
                                                  cancion_id BIGINT,
                                                  PRIMARY KEY (artista_id, cancion_id),
    FOREIGN KEY (artista_id) REFERENCES artistas(id),
    FOREIGN KEY (cancion_id) REFERENCES canciones(id)
    );

CREATE TABLE IF NOT EXISTS canciones_discos (
                                                cancion_id BIGINT,
                                                disco_id BIGINT,
                                                PRIMARY KEY (cancion_id, disco_id),
    FOREIGN KEY (cancion_id) REFERENCES canciones(id),
    FOREIGN KEY (disco_id) REFERENCES discos(id)
    );