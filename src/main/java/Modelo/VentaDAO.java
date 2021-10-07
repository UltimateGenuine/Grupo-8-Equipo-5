package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentaDAO {
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public boolean agregarVenta(VentaDTO ven){
		
		boolean resul=false;
		try {
		String sql="INSERT INTO `tienda_generica`.`ventas` (`cedula_cliente`, `cedula_usuario`, `ivaventa`, `total_venta`, `valor_venta`) VALUES (?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1, ven.getCedulaCliente());
		ps.setInt(2, ven.getCedulaUsuario());
		ps.setDouble(3, ven.getIvaventa());
		ps.setDouble(4, ven.getTotalVenta());
		ps.setDouble(5, ven.getValorVenta());
		resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"No se realizo el registro"+ ex);
		}return resul;
	}
}
