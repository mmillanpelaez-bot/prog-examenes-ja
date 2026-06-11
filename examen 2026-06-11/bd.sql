-- 1. Por si acaso el profesor te pide limpiar ejecuciones anteriores
DROP TABLE IF EXISTS videojuego;

-- 2. Crear la tabla con tipos de datos estándar de PostgreSQL
CREATE TABLE videojuego (
                            codigo VARCHAR(50) PRIMARY KEY, -- PRIMARY KEY evita duplicados en la BD
                            titulo VARCHAR(100) NOT NULL,
                            genero VARCHAR(50),
                            precio INT CHECK (precio >= 0)  -- Un pequeño seguro para que no haya precios negativos
);

-- 3. Insertar un par de filas de prueba para comprobar que el SELECT de Java funciona
INSERT INTO videojuego (codigo, titulo, genero, precio) VALUES
                                                            ('GAME-1001', 'The Witcher 3', 'Rol', 30),
                                                            ('GAME-1002', 'FIFA 26', 'Deportes', 70);