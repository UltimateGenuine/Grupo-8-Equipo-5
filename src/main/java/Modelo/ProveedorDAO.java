package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProveedorDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//METODO INSERTAR
	public boolean Insertar_Proveedor(ProveedorDTO pr) {
		boolean resul = false;
		try {
			
			String sql = "insert into proveedores values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pr.getNit());
			ps.setInt(2, pr.getTelefono());
			ps.setString(3, pr.getNombre());
			ps.setString(4, pr.getCiudad());
			ps.setString(5, pr.getDireccion());
			
			resul = ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"No se registro el Proveedor"+ex);
		}
		return resul;
	}
	
	//METODO BUSCAR
	public ProveedorDTO Buscar_Proveedor(int nit) {
		ProveedorDTO pr = null;
		
		try {
			String sql = "select * from proveedores where nitproveedor =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, nit);
			ps.executeQuery();
			res = ps.executeQuery();
			while(res.next()) {
				pr = new ProveedorDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Consultar Proveedor"+ex);
		}
		return pr;
	}
	
	//METODO PARA ACTUALIZAR
	 public boolean Actualizar_Proveedor(ProveedorDTO pr) {
	        boolean resul=false;
	        try {
	        String sql="update proveedores set telefono_proveedor=?, nombre_proveedor=?, ciudad_proveedor=?, direccion_proveedor=? where nitproveedor=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, pr.getTelefono());
	        ps.setString(2, pr.getNombre());
	        ps.setString(3, pr.getCiudad());
	        ps.setString(4, pr.getDireccion());
	        ps.setInt(5, pr.getNit());
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"Error al actualizar: "+ex);
	        }
	        return resul;
	    }
	 
	 //METODO PARA ELIMINAR
	 public boolean Eliminar_Proveedor(int nit) {
	        boolean resul=false;
	        try {
	        String sql="delete from proveedores where nitproveedor=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, nit);
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"Error al eliminar: "+ex);
	        }
	        return resul;
	    }

}
