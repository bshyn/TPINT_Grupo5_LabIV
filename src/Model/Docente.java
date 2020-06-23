package Model;

public class Docente extends Persona {
	private int id;
	private int legajo;
	private Login login;
	private boolean estado;
	
	public Docente () {
	}
	
	
	public Docente(int id, int legajo, Login login, boolean estado) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.login = login;
		this.estado = estado;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", legajo=" + legajo + ", login=" + login + ", estado=" + estado + ", getDni()="
				+ getDni() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", getDireccion()=" + getDireccion()
				+ ", getLocalidad()=" + getLocalidad() + ", getProvincia()=" + getProvincia() + ", getEmail()="
				+ getEmail() + ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
