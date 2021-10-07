package Modelo;

public class VentaDTO {

	private int cedulaCliente;
	private int cedulaUsuario;
	private double ivaventa;
	private double totalVenta;
	private double valorVenta;
	
	public VentaDTO(int cedulaCliente, int cedulaUsuario, double ivaventa, double totalVenta, double valorVenta) {
		this.cedulaCliente = cedulaCliente;
		this.cedulaUsuario = cedulaUsuario;
		this.ivaventa = ivaventa;
		this.totalVenta = totalVenta;
		this.valorVenta = valorVenta;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public int getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
}
