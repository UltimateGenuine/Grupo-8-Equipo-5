package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductoDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	 //METODO PARA ARCHIVO CSV
	 public boolean Cargar_Producto(String URL) {
		 boolean resul = false;
		 try {
			
			 String sql="load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
			 ps = con.prepareStatement(sql);
			 resul= ps.executeUpdate()>0;
		 }catch(SQLException ex) {
			 JOptionPane.showMessageDialog(null,"Error al registrar los Productos"+ex);
		 }
		 return resul;
	 }
	 
	 public ProductoDTO ConsultarProducto(int codigo) {
	    	
	    	ProductoDTO pro=null;
	    	try {
	    		String sql="SELECT * FROM tienda_generica.productos where codigo_producto=?";
	    		ps=con.prepareStatement(sql);
	    		ps.setInt(1, codigo);
	    		res=ps.executeQuery();
	    		while(res.next()) {
	    			pro= new ProductoDTO(res.getInt(1),res.getString(2),res.getInt(3),res.getDouble(4),res.getDouble(5),res.getDouble(6)); 
	    		}
			
	    	}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar producto" +ex);
	    	}return pro;
	    }

}
