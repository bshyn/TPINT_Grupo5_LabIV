package Negociolmpl;

import java.util.ArrayList;

import Dao.DocenteDao;
import Daolmpl.DocenteDaolmpl;
import Model.Docente;
import Negocio.DocenteNegocio;


public class DocenteNegociolmpl implements DocenteNegocio {
	private DocenteDao docenteDao = new DocenteDaolmpl();
	
	public DocenteNegociolmpl(DocenteDao docenteDao) {
		this.docenteDao = docenteDao;
	}
	
	public DocenteNegociolmpl() {
		
	}
	
	@Override
	public ArrayList<Docente> listarDocentes(){
		return (ArrayList<Docente>) docenteDao.mostrarDocentes();
	}

	
	
	
	
	@Override
	public boolean insertar(Docente docente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Docente docente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
