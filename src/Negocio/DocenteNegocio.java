package Negocio;

import java.util.ArrayList;

import Model.Docente;

public interface DocenteNegocio {
	public ArrayList<Docente> listarDocentes(); 
	public boolean insertar (Docente docente);
	public boolean editar (Docente docente);
	public boolean borrar (int id);
	
}
