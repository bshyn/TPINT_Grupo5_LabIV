package Daolmpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;

import Dao.DocenteDao;
import Model.Docente;
import Model.Persona;

//me obliga a poner la clase DocenteNegociolmpl como abstract

public class DocenteDaolmpl implements DocenteDao {
	
	private Conexion cn;
	
	public DocenteDaolmpl() {
		
	}
	
	@Override
	public List<Docente> mostrarDocentes() {
		cn = new Conexion();
		cn.Open();
		List<Docente> list = new ArrayList<Docente>();
		try {
			ResultSet rs = cn.query("SELECT legajo, dni, nombre, apellido, email FROM docentes INNER JOIN personas ON docentes.legajo_d = personas.legajo");
			while(rs.next()) 
			{							
				Docente docente = new Docente();
				docente.setLegajo(rs.getInt("legajo"));
				docente.setDni(rs.getString("dni"));
				docente.setNombre(rs.getString("nombre"));
				docente.setApellido(rs.getString("apellido"));
				docente.setEmail(rs.getString("email"));
				
				list.add(docente);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}
		return list;
	}
	
	@Override
	public boolean insert(Docente docente) { 
		
		boolean estado = true;
		cn = new Conexion();
		cn.Open();
		String sp = "{CALL SP_Docente(0,'"+docente.getDni()+"','"+docente.getNombre()+"','"+docente.getApellido()+"','"+docente.getFechaNacimiento()+"','"+docente.getDireccion()+"','"+docente.getLocalidad()+"','"+docente.getProvincia()+"','"+docente.getEmail()+"','"+docente.getTelefono()+"','add')}";
		System.out.println(sp);
		  
		try {			
			estado = cn.executeSP(sp); 
		} 
		catch (Exception e) {			
			e.printStackTrace(); 
		} 
		finally {
			cn.close();
		}
		return estado; 
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Docente alumno) {
		// TODO Auto-generated method stub
		return false;
	}

}
