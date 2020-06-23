USE SDG_Educativa;

DELIMITER $$
CREATE PROCEDURE SP_Docente (
IN _legajo INT,
IN _dni VARCHAR(9),
IN _nombre VARCHAR(30),
IN _apellido VARCHAR(30),
IN _fechaNacimiento DATE,
IN _direccion VARCHAR(100),
IN _localidad VARCHAR(30),
IN _provincia VARCHAR(30),
IN _email VARCHAR(35),
IN _telefono VARCHAR(10),

IN accion VARCHAR(10)
)
BEGIN
	DECLARE errno INT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		GET CURRENT DIAGNOSTICS CONDITION 1 errno = MYSQL_ERRNO;
		ROLLBACK;
    END;
    CASE accion 
	WHEN 'add' THEN 	
		START TRANSACTION;        		
			INSERT INTO personas (dni, nombre, apellido, fechaNacimiento, direccion, localidad, provincia, email, telefono, estado) 
					VALUES(_dni, _nombre, _apellido, _fechaNacimiento, _direccion, _localidad, _provincia, _email, _telefono, 1);
				SET @_legajo = LAST_INSERT_ID(); 
			INSERT INTO docentes (legajo_d, login_d, estado) 
					VALUES (@_legajo, null, 1);		
		COMMIT WORK;	
	WHEN 'edit' THEN
		START TRANSACTION;					
			UPDATE personas 
				SET dni = _dni, nombre = _nombre, apellido = _apellido, fechaNacimiento = _fechaNacimiento, direccion = _direccion, 
					localidad = _localidad, provincia = _provincia, email = _email, telefono = _telefono, estado = _estado
				WHERE legajo = _legajo;		
		COMMIT WORK;
    WHEN 'delete' THEN
		START TRANSACTION;			
			UPDATE personas p INNER JOIN docentes d ON d.legajo_d = p.legajo 
				SET p.estado = 0, d.estado = 0 WHERE p.legajo = _legajo;	
		COMMIT WORK;
	WHEN 'query' THEN
		START TRANSACTION;
			SELECT * FROM personas INNER JOIN docentes ON docentes.legajo_d = personas.legajo WHERE legajo_d = _legajo;		
		COMMIT WORK;
    END CASE;
END$$
DELIMITER ;

/*CALL STORED PROCEDURE SP_DOCENTE*/
call SP_Docente (0, '94578747', 'Alan', 'Benitez', '1990-01-01', 'brna 4445', 'Porahí', 'Benavidez', 'alan@gmail.com', '1566565444', 'add');
call SP_Docente (1001, '', '', '', 0 , '', '', '', '', '', 'query');
call SP_Docente (1000, '94568845', 'André', 'Villalta', '1992-11-05', 'smo 2355', 'Don Torcuato', 'Tigre', 'lpa24508@gmail.com', '1561836484', 'edit');
call SP_Docente (1000, '', '', '', 0 , '', '', '', '', '', 'delete');


SELECT * FROM personas INNER JOIN docentes ON docentes.legajo_d = personas.legajo;	
SELECT * FROM DOCENTES;
SELECT * FROM PERSONAS;
SELECT legajo_d, dni, nombre, apellido, email FROM DOCENTES INNER JOIN PERSONAS  ON docentes.legajo_d = personas.legajo

