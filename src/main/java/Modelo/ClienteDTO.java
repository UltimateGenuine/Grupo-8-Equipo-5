package Modelo;

public class ClienteDTO {
	
	private int Cedula;
	private int Telefono;
	private String Nombre;
	private String Correo;
	private String Direccion;
	
	public ClienteDTO(int cedula, int telefono, String nombre, String correo, String direccion) {
		//super();
		Cedula = cedula;
		Telefono = telefono;
		Nombre = nombre;
		Correo = correo;
		Direccion = direccion;
	}

	public int getCedula() {
		return Cedula;
	}

	public void setCedula(int cedula) {
		Cedula = cedula;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	
	
	

}
