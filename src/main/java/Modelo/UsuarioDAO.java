package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//METODO INSERTAR
	public boolean Insertar_Usuario(UsuarioDTO us) {//traer un libro para insertar en la base de datos
		boolean resul = false;// para saber si si se hizo el proceso
		try {
			
			String sql = "insert into usuarios values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, us.getCedula());
			ps.setString(2, us.getUsuario());
			ps.setString(3, us.getNombre());
			ps.setString(4, us.getContraseña());
			ps.setString(5, us.getCorreo());
			
			resul = ps.executeUpdate()>0;
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null,"No se registro el usuario"+ex);
		}
		return resul;
	}
	
	//METODO BUSCAR
	public UsuarioDTO Buscar_Usuario(int cedula) {
		UsuarioDTO us = null;
		
		try {
			String sql = "select * from usuarios where cedula_usuario =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cedula);
			ps.executeQuery();
			res = ps.executeQuery();
			while(res.next()) {
				us = new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Consultar Usuario"+ex);
		}
		return us;
	}
	//METODO PARA ACTUALIZAR
	 public boolean Actualizar_Usuario(UsuarioDTO us) {
	        boolean resul=false;
	        try {
	        String sql="update usuarios set usuario=?, nombre_usuario=?, password=?, email_usuario=? where cedula_usuario=?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, us.getUsuario());
	        ps.setString(2, us.getNombre());
	        ps.setString(3, us.getContraseña());
	        ps.setString(4, us.getCorreo());
	        ps.setInt(5, us.getCedula());
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
	        }
	        return resul;
	    }
	
	 //METODO PARA ELIMINAR
	 public boolean Eliminar_Usuario(int cedula) {
	        boolean resul=false;
	        try {
	        String sql="delete from usuarios where cedula_usuario=?";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, cedula);
	        resul=ps.executeUpdate()>0;    
	        }catch(SQLException ex) {
	            JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
	        }
	        return resul;
	    }

}
