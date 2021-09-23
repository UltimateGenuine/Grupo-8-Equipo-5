package Modelo;

public class UsuarioDTO {
	
	private int Cedula;
	private String Usuario;
	private String Nombre;
	private String Contrase�a;
	private String Correo;
	
	
	public UsuarioDTO(int cedula, String usuario, String nombre, String contrase�a, String correo) {
		//super();
		Cedula = cedula;
		Usuario = usuario;
		Nombre = nombre;
		Contrase�a = contrase�a;
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


	public String getContrase�a() {
		return Contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	
	
	

}
