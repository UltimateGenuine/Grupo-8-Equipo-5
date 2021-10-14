package Modelo;

public class ReporteDTO {
	private int cedula;
	private String nombre;
	private double total;
	
	public ReporteDTO(int cedula, String nombre, double total) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.total = total;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
