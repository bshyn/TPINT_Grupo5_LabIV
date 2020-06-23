package Dao;

import Model.Docente;

import java.util.List;

public interface DocenteDao {
	public boolean insert(Docente alumno);
	public boolean delete(int id);
	public boolean update(Docente alumno);
	public List<Docente> mostrarDocentes();
}
