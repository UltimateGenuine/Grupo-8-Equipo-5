package Modelo;

public class ProveedorDTO {
	
	private int Nit;
	private int Telefono;
	private String Nombre;
	private String Ciudad;
	private String Direccion;
	
	
	public ProveedorDTO(int nit, int telefono, String nombre, String ciudad, String direccion) {
		//super();
		Nit = nit;
		Telefono = telefono;
		Nombre = nombre;
		Ciudad = ciudad;
		Direccion = direccion;
	}


	public int getNit() {
		return Nit;
	}


	public void setNit(int nit) {
		Nit = nit;
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


	public String getCiudad() {
		return Ciudad;
	}


	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	
	
	

}
