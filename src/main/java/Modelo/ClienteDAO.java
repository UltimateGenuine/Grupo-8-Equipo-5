package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//METODO INSERTAR
	public boolean Insertar_Cliente(ClienteDTO cl) {
		boolean resul = false;
		try {
			
			String sql = "insert into clientes values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cl.getCedula());
			ps.setInt(2, cl.getTelefono());
			ps.setString(3, cl.getNombre());
			ps.setString(4, cl.getCorreo());
			ps.setString(5, cl.getDireccion());
			
			resul = ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"No se registro el Cliente"+ex);
		}
		return resul;
	}
	
	//METODO BUSCAR
	public ClienteDTO Buscar_Cliente(int cedula) {
		ClienteDTO cl = null;
		
		try {
			String sql = "select * from clientes where cedula_cliente =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cedula);
			ps.executeQuery();
			res = ps.executeQuery();
			while(res.next()) {
				cl = new ClienteDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Consultar Cliente"+ex);
		}
		return cl;
	}
	
	//METODO PARA ACTUALIZAR
	 public boolean Actualizar_Cliente(ClienteDTO cl) {
	        boolean resul=false;
	        try {
	        String sql="update clientes set telefono_cliente=?, nombre_cliente=?, email_cliente=?, direccion_cliente=? where cedula_cliente=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, cl.getTelefono());
	        ps.setString(2, cl.getNombre());
	        ps.setString(3, cl.getCorreo());
	        ps.setString(4, cl.getDireccion());
	        ps.setInt(5, cl.getCedula());
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"Error al actualizar: "+ex);
	        }
	        return resul;
	    }
	 
	 //METODO PARA ELIMINAR
	 public boolean Eliminar_Cliente(int cedula) {
	        boolean resul=false;
	        try {
	        String sql="delete from clientes where cedula_cliente=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, cedula);
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"Error al eliminar: "+ex);
	        }
	        return resul;
	    }

}
