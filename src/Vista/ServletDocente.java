package Vista;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import Negocio.DocenteNegocio;
import Negociolmpl.DocenteNegociolmpl;

@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DocenteNegocio docenteNegocio = new DocenteNegociolmpl();
	
    public ServletDocente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			String opcion = request.getParameter("Param").toString();
			switch (opcion) {
				case "list": {
					request.setAttribute("listaDocentes", docenteNegocio.listarDocentes());
					RequestDispatcher dispatcher = request.getRequestDispatcher("ListarDocentes.jsp");
					dispatcher.forward(request, response);
					break;
				}
				default:
					break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getParameter("btnAceptar")!=null) {
//			Docente d = new Docente();
//			
//			d.setDni(request.getParameter("txtDni"));
//			d.setNombre(request.getParameter("txtNombre"));
//			d.setApellido(request.getParameter("txtApellido"));
//			
//			d.setFechaNacimiento(request.getParameter("textFechaNac"));
//	
//			d.setDireccion(request.getParameter("txtDireccion"));
//			d.setLocalidad(request.getParameter("txtLocalidad"));
//			d.setProvincia(request.getParameter("txtProvincia"));
//			d.setEmail(request.getParameter("txtEmail"));
//			d.setTelefono(request.getParameter("txtTelefono"));
//		}
	}

}
