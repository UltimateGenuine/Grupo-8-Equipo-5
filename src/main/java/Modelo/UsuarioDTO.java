package Modelo;

public class UsuarioDTO {
	
	private int Cedula;
	private String Usuario;
	private String Nombre;
	private String Contraseña;
	private String Correo;
	
	
	public UsuarioDTO(int cedula, String usuario, String nombre, String contraseña, String correo) {
		//super();
		Cedula = cedula;
		Usuario = usuario;
		Nombre = nombre;
		Contraseña = contraseña;
		Correo = correo;
	}


	public int getCedula() {
		return Cedula;
	}


	public void setCedula(int cedula) {
		Cedula = cedula;
	}


	public String getUsuario() {
		return Usuario;
	}


	public void setUsuario(String usuario) {
		Usuario = usuario;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getContraseña() {
		return Contraseña;
	}


	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	
	
	

}
