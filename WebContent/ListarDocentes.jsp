<%@page import="Model.Docente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SDG_Educativa</title>
</head>
<body>

	<%
		List<Docente> listaD = new ArrayList<Docente>();
		if (request.getAttribute("listaDocentes") != null) {
			listaD = (List<Docente>) request.getAttribute("listaDocentes");
		}
	%>

<!-- 	<a href="Principal.jsp">Inicio</a> -->
	<a href="ServletDocente?Param=list">Listar docentes</a>

<br/><br/><br/>

<%
	if(listaD.size() > 0){
%>
	<table border="1">
		<tr>
			<td><b>LEGAJO</b></td>
			<td><b>DNI</b></td>
			<td><b>NOMBRE</b></td>
			<td><b>APELLIDO</b></td>
			<td><b>FECHA NACIMIENTO</b></td>
			<td><b>DIRECCION</b></td>
			<td><b>LOCALIDAD</b></td>
			<td><b>PROVINCIA</b></td>
			<td><b>EMAIL</b></td>
			<td><b>TELEFONO</b></td>
		</tr>
		<%
			for (Docente d : listaD) {
		%>
		<tr>
			<td><%=d.getLegajo()%></td>
			<td><%=d.getDni()%></td>
			<td><%=d.getNombre()%></td>
			<td><%=d.getApellido()%></td>
			<td><%=d.getFechaNacimiento() %></td>
			<td><%=d.getDireccion()%></td>
			<td><%=d.getLocalidad()%></td>
			<td><%=d.getProvincia()%></td>
			<td><%=d.getEmail()%></td>
			<td><%=d.getTelefono()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
	} else {
	%>
	<h4>No se cargaron registros</h4>
	<%
	}
	%>
	

</body>
</html>