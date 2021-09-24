package Modelo;

public class ProductoDTO {
	private int Codigo;
	private String Nombre;
	private int Nit;
	private double PrecioCompra;
	private double Iva;
	private double PrecioVenta;
	
	
	
	public ProductoDTO(int codigo, String nombre, int nit, double precioCompra, double iva, double precioVenta) {
		//super();
		Codigo = codigo;
		Nombre = nombre;
		Nit = nit;
		PrecioCompra = precioCompra;
		Iva = iva;
		PrecioVenta = precioVenta;
	}



	public int getCodigo() {
		return Codigo;
	}



	public void setCodigo(int codigo) {
		Codigo = codigo;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public int getNit() {
		return Nit;
	}



	public void setNit(int nit) {
		Nit = nit;
	}



	public double getPrecioCompra() {
		return PrecioCompra;
	}



	public void setPrecioCompra(double precioCompra) {
		PrecioCompra = precioCompra;
	}



	public double getIva() {
		return Iva;
	}



	public void setIva(double iva) {
		Iva = iva;
	}



	public double getPrecioVenta() {
		return PrecioVenta;
	}



	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}
	
	
	
	

}
