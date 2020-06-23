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

}
